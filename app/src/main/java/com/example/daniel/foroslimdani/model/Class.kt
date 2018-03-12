package com.example.daniel.foroslimdani.model

/**
 * Created by Daniel on 19/02/2018.
 */
data class Respuesta(val user:User,val users:ArrayList<User>, val tema:Tema, val temas:ArrayList<Tema>,val comentario:Comentario, val comentarios:ArrayList<Comentario>)

data class User(var telefono:String,var nick:String)
data class Tema(val _id:String, val descripcion:String)
data class Comentario(val _id: String, val fecha:String, var post:String, val nick:String)