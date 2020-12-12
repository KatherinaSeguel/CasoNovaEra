package com.example.casonovaera.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATA_BESE_NAME= "Productos_db"
@Database(entities=[MaestraEntity::class], version=1 )
abstract class DataBaseProductos : RoomDatabase() {

    //Método para Dao
    abstract fun getproductosDao(): Daoproductos

    companion object {  //permite acceder a el sin necesidad de crear el objeto de la clase, nombre clase + punto y acceso a lo que está en el companen objet
        @Volatile
        private var INSTANCE: DataBaseProductos? = null
        fun getDataBase(context: Context): DataBaseProductos {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    DataBaseProductos::class.java,
                    DATA_BESE_NAME)
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}