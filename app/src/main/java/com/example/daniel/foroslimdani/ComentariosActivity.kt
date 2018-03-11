package com.example.daniel.foroslimdani

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.daniel.foroslimdani.adapters.CustomAdapterComentarios
import com.example.daniel.foroslimdani.adapters.CustomAdapterTemas
import com.example.daniel.foroslimdani.api.ApiComentariosForo
import com.example.daniel.foroslimdani.model.Comentario

import kotlinx.android.synthetic.main.activity_comentarios.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_activity_comentarios.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ComentariosActivity : AppCompatActivity() {

    val TAG="****DANIEL****"
    private lateinit var comentariosAl:ArrayList<Comentario>
    private lateinit var adapter: CustomAdapterComentarios
    private var _id:String=""
    private var descripcion:String=""
    //private var nick:String=""
    private val apiComentariosForo by lazy {
        ApiComentariosForo.create()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comentarios)
        setSupportActionBar(toolbar)
        _id=intent.getStringExtra("_id")
        descripcion=intent.getStringExtra("descripcion")
        //nick=intent.getStringExtra("nick")
        loadComentarios()
    }

    private fun loadComentarios() {
        apiComentariosForo.getData(_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { respuesta ->
                            this.comentariosAl = respuesta.comentarios
                            showComentarios()
                        },
                        { error ->
                            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                            Log.e(TAG,error.message)
                        }
                )
    }

    private fun showComentarios() {
        adapter = CustomAdapterComentarios(this,R.layout.comentariosrow, comentariosAl )
        rvComentarios.layoutManager = LinearLayoutManager(this)
        rvComentarios.adapter = adapter
    }

}
