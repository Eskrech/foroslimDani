package com.example.daniel.foroslimdani.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daniel.foroslimdani.ComentariosActivity
import com.example.daniel.foroslimdani.model.Tema
import com.example.daniel.foroslimdani.model.User
import kotlinx.android.synthetic.main.row.view.*

/**
 * Created by Daniel on 19/02/2018.
 */
class CustomAdapterTemas (val context: Context,
                          val layout: Int,
                          val dataList: ArrayList<Tema>): RecyclerView.Adapter<CustomAdapterTemas.ViewHolder>(){

    companion object {
        private val REQUEST_DETALLE=0
    }

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


        fun bind(dataItem: Tema,position: Int){
            itemView.tvNombreTema.text= dataItem.descripcion
            itemView.setOnClickListener({
                onItemClick(dataItem)
            })
        }

    }
    private fun onItemClick(dataItem: Tema) {
        val intent = Intent(context as Activity, ComentariosActivity::class.java)
        intent.putExtra("_id",dataItem._id)
        intent.putExtra("descripcion",dataItem.descripcion)
        //intent.putExtra("nick",dataItem2.nick)
        context.startActivityForResult(intent,REQUEST_DETALLE)
    }

}