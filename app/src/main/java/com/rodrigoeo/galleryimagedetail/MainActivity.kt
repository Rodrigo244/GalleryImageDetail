package com.rodrigoeo.galleryimagedetail

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rodrigoeo.galleryimagedetail.adapter.PruebaAdapter
import com.rodrigoeo.galleryimagedetail.model.ListPruebaUno
import com.rodrigoeo.galleryimagedetail.model.PruebaUno
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {

    lateinit var btnadd: Button
    private lateinit var ivImagen: ImageView
    lateinit var rvPrueba: RecyclerView
    lateinit var floatAdd: FloatingActionButton
    private lateinit var adapter: PruebaAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    private var listPruebaMutableList: MutableList<PruebaUno> =
        ListPruebaUno.pruebaList.toMutableList()

    //get picherMedia Galery Phone
    val pickMedia = registerForActivityResult(PickVisualMedia()) { uri -> }


    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPrueba = findViewById(R.id.recyclerViewData)
        floatAdd = findViewById(R.id.add_fab)

        floatAdd.setOnClickListener() {
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))

        }

//        btnadd = findViewById(R.id.btn_Add)
//        ivImagen = findViewById(R.id.imageView)
//        btnadd.setOnClickListener{
//
//
//        }
//
//        pruebaList[0].dateAdd
//        Log.d("fecha", dateTime)


        //*TODO

        initRecyclerView()


    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun initRecyclerView() {
        adapter = PruebaAdapter(pruebaList = listPruebaMutableList)
        val manager = LinearLayoutManager(this)
        rvPrueba.layoutManager = manager
        rvPrueba.adapter = adapter
    }
}


