package com.rodrigoeo.galleryimagedetail

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier
import com.rodrigoeo.galleryimagedetail.model.PruebaUno
import com.rodrigoeo.galleryimagedetail.ui.theme.GalleryImageDetailTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {

    lateinit var btnadd :Button
    private lateinit var ivImagen : ImageView

    //get picherMedia Galery Phone
    val pickMedia = registerForActivityResult(PickVisualMedia()){ uri ->

        if (uri!=null){
            ivImagen.setImageURI(uri)
            Log.d("image", "Seleccionada  $uri")
        }else{
            Log.d("image", "Noooo Seleccionada!!!!!!!!")

        }
    }





    //get datetime
    @RequiresApi(Build.VERSION_CODES.O)
    val dateTime : String = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))


    @RequiresApi(Build.VERSION_CODES.O)
    val pruebaList = listOf<PruebaUno>(
        PruebaUno("Foto_1", dateTime, "Image"),
        PruebaUno("Foto_2", dateTime, "Image"),
        PruebaUno("Foto_3", dateTime, "Image"),
        PruebaUno("Foto_4", dateTime, "Image"),
        PruebaUno("Foto_5", dateTime, "Image"),
        PruebaUno("Foto_6", dateTime, "Image"),
        PruebaUno("Foto_7", dateTime, "Image"))

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnadd = findViewById(R.id.btn_Add)
        ivImagen = findViewById(R.id.imageView)
        btnadd.setOnClickListener{

            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }

        pruebaList[0].dateAdd
        Log.d("fecha", dateTime)
    }
}

