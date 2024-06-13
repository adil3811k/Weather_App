package com.example.weatherapp

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Model.weatherModel
import com.example.weatherapp.Network.apiObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface weatherInterface{
    object  Loading:weatherInterface
    object  error:weatherInterface
    data class sucsess(val weatherModel: weatherModel):weatherInterface
}

class weatherViewModel : ViewModel() {
    private var _uiState:MutableStateFlow<weatherInterface> = MutableStateFlow(weatherInterface.Loading)
    val uiState = _uiState.asStateFlow()

    fun getData(cityNmae:String){
        viewModelScope.launch {
            try {
                val data=  apiObject.apiService.getWeather(cityNmae)
                _uiState.value = weatherInterface.sucsess(data)
            }catch (e:Exception){
                Log.d("try to get data",e.message.toString())
                _uiState.value = weatherInterface.error
            }
        }
    }
    init {
        getData("Bhiwandi")
    }
}