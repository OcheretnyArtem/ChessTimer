package by.ocheretny.chesstimer.ui.composables

import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import by.ocheretny.chesstimer.ui.theme.Crayola
import by.ocheretny.chesstimer.ui.theme.PrimaryTextColor
import by.ocheretny.chesstimer.ui.theme.regularButtonShape

@Composable
fun RegularButton(
    modifier: Modifier = Modifier, text: String,
    colors: ButtonColors = ButtonDefaults.buttonColors(Crayola, PrimaryTextColor),
    onClick: () -> Unit,
) {
    Button(modifier = modifier, onClick = onClick, shape = regularButtonShape, colors = colors) {
        Text(text = text)
    }
}