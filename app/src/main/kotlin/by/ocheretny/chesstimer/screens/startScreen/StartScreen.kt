package by.ocheretny.chesstimer.screens.startScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.chargemap.compose.numberpicker.FullHours
import com.chargemap.compose.numberpicker.Hours
import com.chargemap.compose.numberpicker.HoursNumberPicker

@Preview
@Composable
fun StartScreen() {

    var pickerValue by remember { mutableStateOf<Hours>(FullHours(0, 0)) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        HoursNumberPicker(
            value = pickerValue,
            hoursDivider = {
                Text(text = "Hours")
            },
            minutesDivider = {
                Text(text = "Minutes")
            },
            onValueChange = { hour ->
                pickerValue = hour
            },
            dividersColor = Color.Black
        )
        Button(onClick = {

        }) {
            Text(text = "Set time")
        }
    }
}