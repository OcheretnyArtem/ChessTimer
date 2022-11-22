package by.ocheretny.chesstimer.screens.startScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import by.ocheretny.chesstimer.R
import by.ocheretny.chesstimer.screens.destinations.TimerScreenDestination
import by.ocheretny.chesstimer.ui.composables.RegularButton
import by.ocheretny.chesstimer.ui.theme.Cornflower
import by.ocheretny.chesstimer.ui.theme.PrimaryTextColor
import by.ocheretny.chesstimer.ui.theme.Yellow
import com.chargemap.compose.numberpicker.FullHours
import com.chargemap.compose.numberpicker.Hours
import com.chargemap.compose.numberpicker.HoursNumberPicker
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@RootNavGraph(start = true)
@Destination
fun StartScreen(
    viewModel: StartScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator) {
    val viewState = viewModel.viewState.collectAsState(initial = null).value

    if (viewState?.isDialogVisible == true) {
        HoursPickerDialog(
            onDismissRequest = {
                viewModel.applyAction(StartScreenViewAction.DialogVisibilityChanged(false))
            },
            onOkRequest = {
                navigator.navigate(TimerScreenDestination())
            }
        )
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Yellow),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = R.string.time_limit),
            fontSize = 20.sp,
            color = PrimaryTextColor)

        RegularButton(
            text = stringResource(id = R.string.set_the_time)
        ) {
            viewModel.applyAction(StartScreenViewAction.DialogVisibilityChanged(true))
        }
    }
}

@Composable
fun HoursPickerDialog(
    onDismissRequest: () -> Unit,
    onOkRequest: () -> Unit,
) {
    var pickerValue by remember { mutableStateOf<Hours>(FullHours(0, 0)) }

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Yellow) {
            Box(contentAlignment = Alignment.Center) {
                Column(modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(id = R.string.set_the_time),
                        fontSize = 20.sp,
                        color = PrimaryTextColor)

                    HoursNumberPicker(value = pickerValue,
                        onValueChange = { hour ->
                            pickerValue = hour
                        },
                        hoursDivider = { Text(text = stringResource(id = R.string.column)) },
                        dividersColor = Cornflower)

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        RegularButton(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp),
                            text = stringResource(id = R.string.cancel)) {
                            onDismissRequest()
                        }

                        RegularButton(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp),
                            text = stringResource(id = R.string.ok)) {
                            onOkRequest()
                        }
                    }
                }
            }
        }
    }
}
