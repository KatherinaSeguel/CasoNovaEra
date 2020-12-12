package com.example.casonovaera.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Daodetalles {

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertAllDetalle(mList: List<DetalleEntity>)


//Selecciona todos los datos

    @Query("SELECT * FROM tabla_detalles")
    fun getAllDetalle(): LiveData<List<DetalleEntity>>


    //Selecciona u objeto en específico
//va al DAO y trae el objeto encontrado por ID envuelto en LiveData
    @Query("SELECT * FROM tabla_detalles WHERE id=:mid")//los : es para que sepa que es la variable
    fun getOneDetalleByID(mid: Int): LiveData<List<DetalleEntity>> //yo le paso un id y la query me trae el producto u objeto que encuentre


}
