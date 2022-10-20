package by.ocheretny.chesstimer.screens

import by.ocheretny.chesstimer.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimerScreenViewModel @Inject constructor() :
    BaseViewModel<TimerScreenViewState, TimerScreenViewViewEvent, TimerScreenViewAction>() {

    override val initialViewState: TimerScreenViewState
        get() = TimerScreenViewState.GameStart

    override fun processAction(action: TimerScreenViewAction) = when (action) {
        is TimerScreenViewAction.OnStartButtonPressed -> {
            updateViewState(TimerScreenViewState.GameIsOn(
                "12.44",
                "12.55"
            ))
        }

        is TimerScreenViewAction.OnWhiteFieldPressed -> {

        }

        is TimerScreenViewAction.OnBlackFieldPressed -> {

        }

    }

}
