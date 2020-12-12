package com.example.casonovaera.model.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.casonovaera.Repository
import com.example.casonovaera.model.local.DataBaseProductos
import com.example.casonovaera.model.local.MaestraEntity

class productosViewModel   (application: Application) : AndroidViewModel(application) { //sólo se hereda de la clase ViewModel sin contexto porque no es ROOM(androidViewmodel)
//Linea de arriba se modifica cuando después creo el ROOM

    private val mRepository: Repository
    //variable referencial al repositorio
    init{
        //se instancia el repositorio
        val fruDao = DataBaseProductos.getDataBase(application).getproductosDao()
        mRepository= Repository(fruDao)
        //indico el método que traerá el repository
        mRepository.getDataFromServer(mprod=0)
    }
    //primer fragmento
    fun exposeLiveDataFromServer(): LiveData<List<MaestraEntity>> {
        return mRepository.mLiveDataPri  //devuelve un Listado de frutas observables

    }

    //no lo había hecho
//segundo fragmanto
    //Este elemento será observado por la vista cuando le pase el Id
    fun getOneFrutoskByID(id:Int): LiveData<List<MaestraEntity>> {
        return mRepository.getOneproductokByID(id)
    }

    }