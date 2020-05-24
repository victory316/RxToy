package com.example.rxtoy.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.rxtoy.databinding.AddedFlowItemBinding

class FlowAdapter(val dataSet: ArrayList<String>): Adapter<FlowAdapter.MyViewHolder>() {

    class MyViewHolder(private val itemBinding: AddedFlowItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(paymentBean: Flow) {
            itemBinding.sampleText.text = "A"
        }
    }

    lateinit var binding: AddedFlowItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = AddedFlowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(Flow())
    }
}