package by.ocheretny.chesstimer.screens.timerScreen

import by.ocheretny.chesstimer.base.ViewAction
import by.ocheretny.chesstimer.base.ViewEvent
import by.ocheretny.chesstimer.base.ViewState
import by.ocheretny.chesstimer.models.Player

sealed class TimerScreenViewState : ViewState {

    object GameStart : TimerScreenViewState()

    data class GameIsOn(
        val whitePlayerTimeLeft: String,
        val blackPlayerTimeLeft: String,
    ) : TimerScreenViewState()

}

sealed class TimerScreenViewAction : ViewAction {

    object OnStartButtonPressed : TimerScreenViewAction()

    object OnBlackFieldPressed : TimerScreenViewAction()

    object OnWhiteFieldPressed : TimerScreenViewAction()

}

sealed class TimerScreenViewViewEvent : ViewEvent {

    data class WinnerIsDetermined(val player: Player) : TimerScreenViewViewEvent()

}
