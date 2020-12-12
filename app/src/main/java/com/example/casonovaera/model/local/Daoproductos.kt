package com.example.casonovaera.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Daoproductos {
    //inserta todos datos

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertAllProductos(mList: List<MaestraEntity>)


//Selecciona todos los datos

    @Query("SELECT * FROM maestra_table")
    fun getAllProductos(): LiveData<List<MaestraEntity>>


    //Selecciona u objeto en específico
//va al DAO y trae el objeto encontrado por ID envuelto en LiveData
    @Query("SELECT * FROM maestra_table WHERE id=:mid")//los : es para que sepa que es la variable
    fun getOneProductosByID(mid: Int): LiveData<List<MaestraEntity>> //yo le paso un id y la query me trae el producto u objeto que encuentre

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertAllDetalle(mList: List<DetalleEntity>)


//Selecciona todos los datos

    @Query("SELECT * FROM maestra_table2")
    fun getAllDetalle(): LiveData<List<DetalleEntity>>


    //Selecciona u objeto en específico
//va al DAO y trae el objeto encontrado por ID envuelto en LiveData
    @Query("SELECT * FROM maestra_table2 WHERE id=:mid")//los : es para que sepa que es la variable
    fun getOneDetalleByID(mid: Int): LiveData<List<DetalleEntity>> //yo le paso un id y la query me trae el producto u objeto que encuentre




}