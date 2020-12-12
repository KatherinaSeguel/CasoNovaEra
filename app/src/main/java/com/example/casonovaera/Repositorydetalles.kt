package com.example.casonovaera

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.casonovaera.model.local.Daodetalles
import com.example.casonovaera.model.local.Daoproductos
import com.example.casonovaera.model.local.DetalleEntity
import com.example.casonovaera.model.pojo.detalleItem
import com.example.casonovaera.model.remote.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repositorydetalles (private val detalleDao: Daodetalles) {

    private val servicede = RetrofitClient.getRetrofitClient()
    val mLiveDatade = detalleDao.getOneDetalleByID(mid = 0)

    val mLiveDataPride=detalleDao.getAllDetalle()


    //La vieja confiable
    fun getDataFromServerdeta(mdeta:Int) {
        val callde = servicede.fetchAllDetalles()
        callde.enqueue(object : Callback<detalleItem> {


            override fun onFailure(call: Call<detalleItem>, t: Throwable) {
                Log.e("Repository",t.message.toString())

            }

            override fun onResponse(call: Call<detalleItem>, response: Response<detalleItem>)
            {
                when(response.code()){
                    //***se cambia***  in 200..299 -> mLiveData.postValue(response.body())
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {

                            Log.d("Info",it.toString())

                            detalleDao.insertAllDetalle(converterde(listOf(it)))


                        }
                    }
                    in 300..399 -> Log.d("ERROR 300",response.errorBody().toString())
                    in 400..499 -> Log.d("ERROR 400",response.errorBody().toString())
                }
            }


        }) //llamadas asincronas

    }
    fun converterde(list: List<detalleItem>):List<DetalleEntity>{

        var listadoDetalle:MutableList<DetalleEntity> = mutableListOf<DetalleEntity>()
        list.map {
            listadoDetalle.add(DetalleEntity(it.id,it.credit,it.description,it.image,it.lastPrice,it.name,it.price))
        }
        return listadoDetalle
    }

    //esto tampoco lo había hecho
    //segundo fragmanto
    //Este elemento será observado por la vista cuando le pase el Id
    fun getOnedetallekByID(id:Int): LiveData<List<DetalleEntity>> {
        return detalleDao.getOneDetalleByID(id)

    }


}