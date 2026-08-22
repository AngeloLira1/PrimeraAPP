package com.example.primeraapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel(){
    //1.PRIVADA: El ViewModel puede cambiar el valor (Mutable)
    private val _numero= MutableLiveData(0)

    //2.PUBLICA: La Activity SOLO puede observar(Live Data), no puede modiificar
    val numero: LiveData<Int>get()=_numero

    fun incrementar() {
        val actual = _numero.value ?: 0
        if (actual < 10) {
            _numero.value = actual + 1
        }
    }

    fun decrementar(){
        val actual=_numero.value?:0
        if(actual>0)_numero.value=actual-1
    }
    fun reset(){
        _numero.value = 0
    }

}