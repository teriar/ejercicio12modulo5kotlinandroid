package com.example.cl.ejercicio12modulo5javaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main(){
    var Usuarios = mutableListOf<Usuario>()
    println("ingresar cantidad de usuarios")
     val cantidadUsuarios=  readln().toInt()

    for(i in 1 .. cantidadUsuarios){
      println("Ingrese el nombre")
       var nombre = readln()

        while (validarNombre(nombre)){
            println("nombre invalido Ingrese nombre valido")
            nombre = readln()
        }

        println("Ingrese el apellido")
        var apellido = readln()
        while (validarApellido(apellido)){
            println("apellido invalido Ingrese nuevamente")
            apellido = readln()
        }
        println("Ingrese edad")
        var edad = readln()
        while (validarEdad(edad)){
            println("edad invalida Ingrese nuevamente")
            edad = readln()
        }
        println("Ingrese correo")
        var correo = readln()
        while (validarCorreo(correo)){
            println("correo invalido Ingrese nuevamente")
            correo = readln()
        }
        println("Ingrese sistema de salud isapre o fonasa")
        var sistemaSalud = readln()
        while (validarSistemaSalud(sistemaSalud)){
            println(" invalido Ingrese nuevamente")
            sistemaSalud = readln()
        }
       var usuario = Usuario(nombre,apellido,edad,correo,sistemaSalud)
        Usuarios.add(usuario)
    }

    for(u in  Usuarios.sortedBy { usuario -> usuario.edad  }){
        println(u)
    }

}

fun validarApellido(apellido: String):Boolean {
    val specialCharsAndNumbers = Regex("[^a-zA-Z ]")
    if(specialCharsAndNumbers.containsMatchIn(apellido)){
       return true

    }
        return false

}

fun validarNombre(nombre: String):Boolean {
    val specialCharsAndNumbers = Regex("[^a-zA-Z ]")
  return  nombre.length in 1..20 && specialCharsAndNumbers.containsMatchIn(nombre)
}

fun validarEdad(edad:String): Boolean {
    if(edad.toInt() >150 ){
        return true
    }
    val onlyNumbers = Regex("\\d+")
    if( onlyNumbers.matches(edad)){
        return false
    }
    return true
}
fun validarCorreo(correo: String):Boolean{
    val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
     if( correo.matches(emailRegex)) {
         return false
     }
    return true
}

fun validarSistemaSalud(sistemaSalud: String): Boolean {
    if( sistemaSalud.toLowerCase()=="fonasa" || sistemaSalud.toLowerCase()=="isapre" || sistemaSalud.toLowerCase() == "particular"){
        return false;
    }
        return true

}


data class Usuario ( var nombre:String,  var apellido:String , var edad: String , var correo:String , var sistemaSalud:String  )