package com.example.rxtoy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rxtoy.databinding.ActivityPianoBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class PianoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPianoBinding

    private var compositeDisposable = CompositeDisposable()

    private var publishSubject: PublishSubject<String> = PublishSubject.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPianoBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setupUI()
        setupTestObservable()
    }

    private fun setupUI() {

        binding.addButton.setOnClickListener {
            addNewFlow()
        }
    }

    private fun addNewFlow() {
        Toast.makeText(this, "Adding new flow", Toast.LENGTH_SHORT).show()

        val latestText = binding.inputText.text.toString()

        publishSubject.onNext(latestText)
    }

    private fun setupTestObservable() {
        compositeDisposable.add(publishSubject
            .delay(1000, TimeUnit.MILLISECONDS)
            .observeOn(Schedulers.newThread())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe {
                val currentText = binding.bottomTextView.text
                val stringBuffer = StringBuffer()
                stringBuffer.append(currentText)
                stringBuffer.append(it)

                binding.bottomTextView.text = stringBuffer.toString()
//                publishSubject.onNext(latestText)
            })
    }

    override fun onDestroy() {
        compositeDisposable.clear()

        super.onDestroy()
    }
}
