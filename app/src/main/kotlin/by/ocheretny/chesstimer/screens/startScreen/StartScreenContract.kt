package by.ocheretny.chesstimer.screens.startScreen

import by.ocheretny.chesstimer.base.ViewAction
import by.ocheretny.chesstimer.base.ViewEvent
import by.ocheretny.chesstimer.base.ViewState

data class StartScreenViewState(
    val isDialogVisible: Boolean = false,
    val selectedTimeInMin: Int = 0,
) : ViewState

sealed class StartScreenViewEvent : ViewEvent {
    object NavigateToTimerScreen : StartScreenViewEvent()
    data class MakeToast(val messageId: Int) : StartScreenViewEvent()
}

sealed class StartScreenViewAction : ViewAction {
    data class DialogVisibilityChanged(val isDialogVisible: Boolean) : StartScreenViewAction()
    data class OnDialogOkButtonClicked(val min: Int) : StartScreenViewAction()

}
