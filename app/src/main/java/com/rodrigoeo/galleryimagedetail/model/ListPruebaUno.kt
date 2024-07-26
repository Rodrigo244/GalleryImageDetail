package com.rodrigoeo.galleryimagedetail.model

import android.os.Build
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ListPruebaUno {
    companion object{
        //get datetime
        @RequiresApi(Build.VERSION_CODES.O)
        val dateTime : String = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))


        @RequiresApi(Build.VERSION_CODES.O)
        val pruebaList = listOf<PruebaUno>(
            PruebaUno("Foto_1", dateTime, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/shiny/132.png"),
            PruebaUno("Foto_2", dateTime, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/shiny/132.png"),
            PruebaUno("Foto_3", dateTime, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/shiny/132.png"),
            PruebaUno("Foto_4", dateTime, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/shiny/132.png"),
            PruebaUno("Foto_5", dateTime, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/6.png"),
            PruebaUno("Foto_6", dateTime, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/6.png"),
            PruebaUno("Foto_7", dateTime, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/6.png"))
    }





}

