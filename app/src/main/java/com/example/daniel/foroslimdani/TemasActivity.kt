package com.example.daniel.foroslimdani

import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.daniel.foroslimdani.adapters.CustomAdapterTemas
import com.example.daniel.foroslimdani.api.ApiTemasForo
import com.example.daniel.foroslimdani.model.Respuesta
import com.example.daniel.foroslimdani.model.Tema
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class TemasActivity : AppCompatActivity() {

    val TAG="****DANIEL****"
    private lateinit var temasAl:ArrayList<Tema>
    private lateinit var adapter: CustomAdapterTemas
    private val apiTemasForo by lazy {
        ApiTemasForo.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadTemas()
    }
    private fun loadTemas(){
        apiTemasForo.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { respuesta ->
                            this.temasAl = respuesta.temas
                            showTemas()
                        },
                        { error ->
                            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                            Log.e(TAG,error.message)
                        }
                )
    }

    private fun showTemas() {
        adapter = CustomAdapterTemas(this,R.layout.row, temasAl )
        rvTemas.layoutManager = LinearLayoutManager(this)
        rvTemas.adapter = adapter
    }
}
