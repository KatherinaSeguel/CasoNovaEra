package com.example.casonovaera.model.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.*
import com.example.casonovaera.R
import com.example.casonovaera.model.local.MaestraEntity
import kotlinx.android.synthetic.main.primer.view.*

class productoAdapter  (var mPasstheData:PasstheData):RecyclerView.Adapter<productoAdapter.ProductoViewHolder>() { //paso 4 ,Implementar Recycler View

        private  var mData= emptyList<MaestraEntity>()  //paso 1

        //cada vez que haya un cambio actualiza la lista

        fun updateFrutos(mStringList: List<MaestraEntity>) {  //paso 2

            mData = mStringList        //paso 2
            notifyDataSetChanged()
        }

        inner class ProductoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{  //paso 3
            // val itemView = itemView.setOnClickListener(this) cuando es imagen

            var mitemView = itemView.id  //texview que está en ItemLIst
            var imagen= itemView.imageproducto
            var nombreUno= itemView.nombrepro
            val precioUno= itemView.preciopro

            val itemView = itemView.setOnClickListener(this)  // Cuando se hace click en el texto


            override fun onClick(p0: View?) {    //paso 5
                mPasstheData.passTheData(mData[adapterPosition])
            }



        }


        //esto se genera después del paso 4, son los métodos que se generan
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {//paso 4.1
            //creas el viewholder, trabaja en el xml,se crea el XML
            val itemView= LayoutInflater.from(parent.context).inflate(R.layout.primer,parent,false)

            return ProductoViewHolder(itemView)

        }


        override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {//paso 4.2
            //llena el xml con los objetos del listado, une los datos con los elementos

            val mfrut= mData[position]

            with(holder.itemView.context).load(mData[position].image).into(holder.imagen)

            holder.mitemView= mfrut.id
            holder.nombreUno.text=mfrut.name
           // holder.precioUno= mfrut.price

        }

        override fun getItemCount(): Int {   // paso 4.3
            //este tienen el total de elementos
            return mData.size
        }


        //esta interface se declara y se ocupa en el primer fragmanto .
        interface PasstheData{

            fun passTheData(mFrut:MaestraEntity)
        }




    }