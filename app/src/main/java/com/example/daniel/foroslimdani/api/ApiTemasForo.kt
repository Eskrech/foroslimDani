package com.example.daniel.foroslimdani.api

import com.example.daniel.foroslimdani.model.Respuesta
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable
import java.util.*

/**
 * Created by Daniel on 19/02/2018.
 */
interface ApiTemasForo {
    @GET("temas")
    fun getData(): Observable<Respuesta>

    companion object {
        fun create(): ApiTemasForo {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("http://192.168.1.217/foroslim/")
                    .build()
            return retrofit.create(ApiTemasForo::class.java)
        }
    }
}