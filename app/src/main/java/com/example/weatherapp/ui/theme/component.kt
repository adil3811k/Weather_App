package com.example.weatherapp.ui.theme

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.Model.Main
import com.example.weatherapp.Model.cardModel
import com.example.weatherapp.R
import com.example.weatherapp.utiliy_Functions


@Composable
fun temperature_compos(main: Main,modifier: Modifier = Modifier) {
    Card (
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)

    ){
        Text(text = "Temperature", modifier = modifier
            .padding(20.dp)
            .align(Alignment.CenterHorizontally),
            style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ))
        Row (
            modifier=modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            itemCompos(tital = "Temperature", data = utiliy_Functions.KalvinToCenlius(main.temp))
            itemCompos(tital = "Feel", data = utiliy_Functions.KalvinToCenlius( main.feels_like))
            itemCompos(tital = "Min", data = utiliy_Functions.KalvinToCenlius(main.temp_min))
            itemCompos(tital = "Max", data =utiliy_Functions.KalvinToCenlius( main.temp_max))

        }
    }
}




@Composable
private fun itemCompos(modifier: Modifier = Modifier,tital:String,data:String) {
    Card (
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                modifier= modifier,
        elevation = CardDefaults.cardElevation(0.3.dp),
    ){
        Text(text = tital, modifier = modifier
            .padding(8.dp)
            .align(Alignment.CenterHorizontally))
        Text(text = data,modifier = modifier
            .padding(8.dp)
            .align(Alignment.CenterHorizontally))
    }
}


@Composable
fun statusCompose(status:String,discription:String,modifier: Modifier = Modifier) {
    Column (modifier= modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = status, style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold,))
        Text(text = discription, style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Thin,))
    }
}

@Composable
fun cardcompose(cardModel: cardModel,modifier: Modifier = Modifier) {
    Card (modifier = modifier
        .padding(10.dp)
        .fillMaxWidth(0.4f)){
        Icon(
            painter = painterResource(cardModel.icon),
            contentDescription = "Icon",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(82.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = cardModel.tital,
            modifier = modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontWeight = FontWeight.Bold))
        Text(
            text = cardModel.data,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 10.dp)
        )

    }
}

@Preview(showSystemUi = true)
@Composable
private fun cardComposePrevi() {
    cardcompose(cardModel = cardModel(R.drawable.humidity,"Humidity","67hPa"))
}





