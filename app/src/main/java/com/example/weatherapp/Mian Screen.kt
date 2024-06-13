package com.example.weatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.cardcompose
import com.example.weatherapp.ui.theme.statusCompose
import com.example.weatherapp.ui.theme.temperature_compos

@Composable
fun MainCompos(modifier: Modifier = Modifier,weatherInterface: weatherInterface.sucsess) {
        Column {
                statusCompose(
                        status = weatherInterface.weatherModel.weather[0].main,
                        discription = weatherInterface.weatherModel.weather[0].description,
                        modifier = modifier.padding(vertical = 20.dp)
                )
                temperature_compos(main = weatherInterface.weatherModel.main)
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        items(utiliy_Functions.getListbywetherModel(weatherInterface.weatherModel)){
                                cardcompose(cardModel = it)
                        }
                }
        }
}
