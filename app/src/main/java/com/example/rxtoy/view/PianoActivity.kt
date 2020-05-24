package com.example.rxtoy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rxtoy.databinding.ActivityPianoBinding
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

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
        compositeDisposable.clear()

        Toast.makeText(this, "Adding new flow", Toast.LENGTH_SHORT).show()

        val latestText = binding.inputText.text.toString()

        compositeDisposable.add(publishSubject
            .delay(1000, TimeUnit.MILLISECONDS)
            .subscribe {
                val currentText = binding.bottomTextView.text
                val stringBuffer = StringBuffer()
                stringBuffer.append(currentText)
                stringBuffer.append(it)

                binding.bottomTextView.text = stringBuffer.toString()
                publishSubject.onNext(latestText)
            })


        publishSubject.onNext(latestText)
    }

    private fun setupTestObservable() {

    }

    override fun onDestroy() {
        compositeDisposable.clear()

        super.onDestroy()
    }
}
