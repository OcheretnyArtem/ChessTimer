package by.ocheretny.chesstimer.screens.timerScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import by.ocheretny.chesstimer.models.Player

private const val TEXT_ROTATION_DEGREES = 180f

@Composable
fun TimerScreen(viewModel: TimerScreenViewModel = hiltViewModel()) {

    val viewState = viewModel.viewState.collectAsState().value

    when (viewState) {

        is TimerScreenViewState.GameStart -> {
            GameStart(
                onStartButtonClick = {
                    viewModel.applyAction(TimerScreenViewAction.OnStartButtonPressed)
                }
            )
        }

        is TimerScreenViewState.GameIsOn -> {
            BattleField(
                state = viewState,
                onWhiteClick = {
                    viewModel.applyAction(TimerScreenViewAction.OnWhiteFieldPressed)
                },
                onBlackClick = {
                    viewModel.applyAction(TimerScreenViewAction.OnBlackFieldPressed)
                })
        }

    }

}

@Composable
private fun BattleField(
    state: TimerScreenViewState.GameIsOn,
    onBlackClick: () -> Unit,
    onWhiteClick: () -> Unit,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)) {
        PlayerField(
            modifier = Modifier.weight(1f),
            player = Player.Black,
            timeLeft = state.blackPlayerTimeLeft,
            onClick = onBlackClick
        )
        PlayerField(
            modifier = Modifier.weight(1f),
            player = Player.White,
            timeLeft = state.whitePlayerTimeLeft,
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

@Composable
fun GameStart(onStartButtonClick: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White), contentAlignment = Alignment.Center) {
        Button(
            onClick = onStartButtonClick,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(50)) {
            Text(text = "START", color = Color.White)
        }
    }
}

private data class FieldSettings(
    val fieldColor: Color,
    val textColor: Color,
    val rotation: Float,
)
