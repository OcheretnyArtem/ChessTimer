package by.ocheretny.chesstimer.screens.timerScreen

import androidx.lifecycle.viewModelScope
import by.ocheretny.chesstimer.base.BaseViewModel
import by.ocheretny.chesstimer.data.stopwatch.StopwatchSrc
import by.ocheretny.chesstimer.models.Black
import by.ocheretny.chesstimer.models.White
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("IMPLICIT_CAST_TO_ANY")
@HiltViewModel
class TimerScreenViewModel @Inject constructor(
    private val stopwatchSrc: StopwatchSrc,
) : BaseViewModel<TimerScreenViewState, TimerScreenViewViewEvent, TimerScreenViewAction>() {

    override val initialViewState: TimerScreenViewState
        get() = TimerScreenViewState.GameStart

    override fun processAction(action: TimerScreenViewAction) = when (action) {
        is TimerScreenViewAction.OnStartButtonPressed -> {
            stopwatchSrc.setTime(50)
            updateViewState(TimerScreenViewState.GameIsOn("0", "0"))
            viewModelScope.launch {
                stopwatchSrc.observeWhiteTime(White).collect {
                    updateViewState(
                        (currentViewState as TimerScreenViewState.GameIsOn).copy(
                            whitePlayerTimeLeft = it.toString()
                        )
                    )
                }
            }
            viewModelScope.launch {
                stopwatchSrc.observeWhiteTime(Black).collect {
                    updateViewState(
                        (currentViewState as TimerScreenViewState.GameIsOn).copy(
                            blackPlayerTimeLeft = it.toString()
                        )
                    )
                }
            }

        }

        is TimerScreenViewAction.OnWhiteFieldPressed -> {

        }

        is TimerScreenViewAction.OnBlackFieldPressed -> {

        }

    }

}
