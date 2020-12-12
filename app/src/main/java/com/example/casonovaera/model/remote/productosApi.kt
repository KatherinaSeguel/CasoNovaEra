package com.example.casonovaera.model.remote

import com.example.casonovaera.model.pojo.detalleItem
import com.example.casonovaera.model.pojo.productosItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface productosApi {

    //Vieja confiable
    @GET("products/")
    fun fetchAllProductos(): Call<productosItem>

    @GET("details/1")
    fun fetchAllDetalles(): Call<detalleItem>




    //Coroutines
    @GET("products/")
    suspend fun fetchAllProductosWithCoroutines(): Response<productosItem>

    //Detalle de la producto
    @GET("products/")  //Llega un Listado de Frutos y Frutos es un List de Result(Aquí vienen con detalles)
    fun getDataFromApi() : Call<productosItem>


    //Detalle
    @GET("details/1")  //Llega un Listado de Frutos y Frutos es un List de Result(Aquí vienen con detalles)
    fun getDataFromApidetalle() : Call<detalleItem>



    // @GET("breeds/list/")
    // suspend fun fetchBreedListCorutinas(): Response<Result>

    //Buscar un fruto
    @GET("products/")
    fun getDataFromApiCorutines(@Query("fruto") mFrutos:String): retrofit2.Response<productosItem>





}