package com.rodrigoeo.galleryimagedetail.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.rodrigoeo.galleryimagedetail.R
import com.rodrigoeo.galleryimagedetail.model.ListPruebaUno
import com.rodrigoeo.galleryimagedetail.model.PruebaUno
import com.squareup.picasso.Picasso



class PruebaAdapter( val pruebaList: List<PruebaUno>):RecyclerView.Adapter<PruebaAdapter.AdapterHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AdapterHolder(layoutInflater.inflate(R.layout.item_recyclerview, parent,false))
    }

    override fun getItemCount(): Int {
        return pruebaList.size
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        val item = pruebaList[position]
        holder.renderView(item)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun deleteItem(index: Int) {
        listPruebaMutableList.removeAt(index)
        notifyItemRemoved(index)
    }



    @RequiresApi(Build.VERSION_CODES.O)
    private var listPruebaMutableList:MutableList<PruebaUno> = ListPruebaUno.pruebaList.toMutableList()
    class AdapterHolder(val viewItem: View):RecyclerView.ViewHolder(viewItem) {


        private lateinit var icon: ImageView
        private lateinit var name: TextView
        private lateinit var date: TextView
        private lateinit var btndelete: ImageButton


        fun renderView(viewUno: PruebaUno) {
            icon = viewItem.findViewById(R.id.ivGallery)
            name = viewItem.findViewById(R.id.tvName)
            date = viewItem.findViewById(R.id.tvDate)
            btndelete = viewItem.findViewById(R.id.ibtn_delete)

            Picasso.get().load(viewUno.photo).into(icon)
            name.text = viewUno.name
            date.text = viewUno.dateAdd

            // setOnClickListener btnDelete
            btndelete.setOnClickListener() {

                Toast.makeText(viewItem.context, "Borrar Item", Toast.LENGTH_SHORT).show()
            }

            //setOnClickListenerImageFull
            viewItem.setOnClickListener() {
                Toast.makeText(viewItem.context, "Full Imagen", Toast.LENGTH_SHORT).show()
            }

        }

    }


}
