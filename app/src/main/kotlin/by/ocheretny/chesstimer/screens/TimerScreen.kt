package by.ocheretny.chesstimer.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import by.ocheretny.chesstimer.models.Player

private const val TEXT_ROTATION_DEGREES = 180f

@Composable
fun TimerScreen() {







    }

@Composable
private fun BattleField(
    blackPlayerTimeLeft: String,
    whitePlayerTimeLeft: String,
    onBlackClick: () -> Unit,
    onWhiteClick: () -> Unit,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)) {
        PlayerField(
            modifier = Modifier.weight(1f),
            player = Player.Black,
            timeLeft = blackPlayerTimeLeft,
            onClick = onBlackClick
        )
        PlayerField(
            modifier = Modifier.weight(1f),
            player = Player.White,
            timeLeft = whitePlayerTimeLeft,
            onClick = onWhiteClick)
    }
}

@Composable
private fun PlayerField(
    modifier: Modifier,
    player: Player,
    timeLeft: String,
    onClick: () -> Unit = {},
) {
    val fieldSettings: FieldSettings = when (player) {
        is Player.Black -> FieldSettings(Color.Black,
            textColor = Color.White,
            rotation = TEXT_ROTATION_DEGREES)
        is Player.White -> FieldSettings(Color.White, textColor = Color.Black, rotation = 0f)
    }
    Box(modifier = modifier
        .fillMaxWidth()
        .background(fieldSettings.fieldColor)
        .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Text(text = timeLeft,
            color = fieldSettings.textColor,
            modifier = Modifier.rotate(fieldSettings.rotation),
            fontSize = 25.sp)
    }
}

private data class FieldSettings(
    val fieldColor: Color,
    val textColor: Color,
    val rotation: Float,
)