package com.example.udemy_retrofit_kripto.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.udemy_retrofit_kripto.R
import com.example.udemy_retrofit_kripto.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*

open class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>, val listener : Listener)
    : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface  Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }

    var colors: Array<String> = arrayOf("#29082f","#775fec","#090ece","#30e641","#711cfc","#507967","#a8c79d")

    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(cryptoModel: CryptoModel, colors:Array<String>, position: Int, listener: Listener){
            itemView.apply {
                textPrice.text = cryptoModel.price
                textName.text = cryptoModel.currency
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 7]))
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }
    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)
    }

    override fun getItemCount(): Int {
        return  cryptoList.size
    }
}