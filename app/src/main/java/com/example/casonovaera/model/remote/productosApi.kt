package com.example.casonovaera.model.remote

import com.example.casonovaera.model.pojo.productosItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface productosApi {

    //Vieja confiable
    @GET("products/")
    fun fetchAllProductos(): Call<productosItem>

    //Coroutines
    @GET("products/")
    suspend fun fetchAllProductosWithCoroutines(): Response<productosItem>

    //Detalle de la fruta
    @GET("products/")  //Llega un Listado de Frutos y Frutos es un List de Result(Aquí vienen con detalles)
    fun getDataFromApi() : Call<productosItem>

    // @GET("breeds/list/")
    // suspend fun fetchBreedListCorutinas(): Response<Result>

    //Buscar un fruto
    @GET("products/")
    fun getDataFromApiCorutines(@Query("fruto") mFrutos:String): retrofit2.Response<productosItem>





}