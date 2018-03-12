package com.example.daniel.foroslimdani.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daniel.foroslimdani.model.Comentario
import kotlinx.android.synthetic.main.comentariosrow.view.*

/**
 * Created by Daniel on 10/03/2018.
 */
class CustomAdapterComentarios (val context: Context,
                                val layout: Int,
                                val dataList: ArrayList<Comentario>): RecyclerView.Adapter<CustomAdapterComentarios.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item,position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {


        fun bind(dataItem: Comentario, position: Int){
            itemView.tvComentario.text= dataItem.post
            itemView.tvFecha.text = dataItem.fecha
            itemView.tvNick.text = dataItem.nick
            itemView.setOnClickListener({
                onItemClick(dataItem)
            })
        }

    }
    private fun onItemClick(dataItem: Comentario) {
    }

}