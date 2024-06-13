package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel:weatherViewModel  = ViewModelProvider(this)[weatherViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            val uiState= viewModel.uiState.collectAsState()
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    wetherApp(paddingValues = innerPadding,weatherInterface = uiState.value) {
                        viewModel.getData(it)
                    }
                }
            }
        }
    }
}

@Composable
fun wetherApp(paddingValues: PaddingValues, modifier: Modifier = Modifier,weatherInterface: weatherInterface,onSearch:(String)->Unit) {
    Column(
        modifier = modifier.padding(paddingValues = paddingValues)
    ) {
        var cityname by remember {
            mutableStateOf("")
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedTextField(
                value = cityname,
                onValueChange = {cityname = it},
                maxLines = 1,
                modifier = modifier
                    .weight(1f)
                    .padding(10.dp),
                label = { Text(text = "Enter the country Name")},
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)

            )
            IconButton(onClick = { onSearch(cityname)
            cityname =  ""}) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    Modifier.size(40.dp)
                        .padding(end = 10.dp)
                )
            }
        }
        when(weatherInterface){
            com.example.weatherapp.weatherInterface.Loading ->{
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    CircularProgressIndicator()
                }
            }
            com.example.weatherapp.weatherInterface.error -> {
                Box {
                    Text(text = "Pleas enter current country name ")
                }
            }
            is weatherInterface.sucsess -> {
                MainCompos(weatherInterface = weatherInterface)
            }
        }
    }
}


