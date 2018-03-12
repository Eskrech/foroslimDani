package com.example.daniel.foroslimdani.api

import com.example.daniel.foroslimdani.model.Respuesta
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by Daniel on 10/03/2018.
 */
interface ApiComentariosForo {
    @GET("tema/{tema}/comentarios")
    fun getData(@Path("tema") tema:String): Observable<Respuesta>

    companion object {
        fun create(): ApiComentariosForo {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("http://192.168.1.217/foroslim/")
                    .build()
            return retrofit.create(ApiComentariosForo::class.java)
        }
    }
}