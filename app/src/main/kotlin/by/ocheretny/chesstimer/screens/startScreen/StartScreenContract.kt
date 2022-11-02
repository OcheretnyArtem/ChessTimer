package by.ocheretny.chesstimer.screens.startScreen

import by.ocheretny.chesstimer.base.ViewAction
import by.ocheretny.chesstimer.base.ViewEvent
import by.ocheretny.chesstimer.base.ViewState
import com.chargemap.compose.numberpicker.FullHours
import com.chargemap.compose.numberpicker.Hours

data class StartScreenViewState(
    val isDialogVisible: Boolean = false,
) : ViewState

sealed class StartScreenViewEvent : ViewEvent{

}

sealed class StartScreenViewAction : ViewAction {
    data class DialogVisibilityChanged(val isDialogVisible: Boolean) : StartScreenViewAction()
    object NavigateToTimerScreen : StartScreenViewAction()

}
