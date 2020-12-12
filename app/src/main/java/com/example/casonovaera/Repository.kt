package com.example.casonovaera

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.casonovaera.model.local.Daodetalles
import com.example.casonovaera.model.local.Daoproductos
import com.example.casonovaera.model.local.DetalleEntity
import com.example.casonovaera.model.local.MaestraEntity
import com.example.casonovaera.model.pojo.detalleItem
import com.example.casonovaera.model.pojo.productosItem
import com.example.casonovaera.model.remote.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val producDao: Daoproductos) {
    private val service = RetrofitClient.getRetrofitClient()
    val mLiveData = producDao.getOneProductosByID(mid = 0)
    val mLiveDataPri=producDao.getAllProductos()





        //La vieja confiable
        fun getDataFromServer(mprod:Int) {
            val call = service.getDataFromApi()
            call.enqueue(object : Callback<productosItem> {


                override fun onFailure(call: Call<productosItem>, t: Throwable) {
                    Log.e("Repository",t.message.toString())

                }

                override fun onResponse(call: Call<productosItem>, response: Response<productosItem>)
                {
                    when(response.code()){
                        //***se cambia***  in 200..299 -> mLiveData.postValue(response.body())
                        in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                            response.body()?.let {

                                Log.d("Info",it.toString())
                                producDao.insertAllProductos(converter(listOf(it)))


                            }
                        }
                        in 300..399 -> Log.d("ERROR 300",response.errorBody().toString())
                        in 400..499 -> Log.d("ERROR 400",response.errorBody().toString())
                    }
                }


            }) //llamadas asincronas

        }




        // En este metodo paso de datos o objeto  ,, varieble listadoDeRazas= listadoDeFrutas
        //se hace este función si lo que trae la database es distinto a lo que yo quiero en el ROOM
        //Aquí lo transformo.
        fun converter(list: List<productosItem>):List<MaestraEntity>{

            var listadoDeproductos:MutableList<MaestraEntity> = mutableListOf<MaestraEntity>()
            list.map {
                listadoDeproductos.add(MaestraEntity(it.id,it.image,it.name,it.price))
            }
            return listadoDeproductos
        }





        //esto tampoco lo había hecho
        //segundo fragmanto
        //Este elemento será observado por la vista cuando le pase el Id
        fun getOneproductokByID(id:Int): LiveData<List<MaestraEntity>> {
            return producDao.getOneProductosByID(id)
        }





    }