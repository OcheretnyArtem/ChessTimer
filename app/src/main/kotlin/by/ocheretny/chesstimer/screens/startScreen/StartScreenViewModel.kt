package by.ocheretny.chesstimer.screens.startScreen

import by.ocheretny.chesstimer.R
import by.ocheretny.chesstimer.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartScreenViewModel @Inject constructor() :
    BaseViewModel<StartScreenViewState, StartScreenViewEvent, StartScreenViewAction>() {

    override val initialViewState: StartScreenViewState = StartScreenViewState()

    override fun processAction(action: StartScreenViewAction) {
        when (action) {
            is StartScreenViewAction.DialogVisibilityChanged -> {
                updateViewState(StartScreenViewState(isDialogVisible = action.isDialogVisible))
            }

            is StartScreenViewAction.OnDialogOkButtonClicked -> {
                if (action.min > 0) {
                    sendNewTimeValue(action.min)
                    updateViewState(StartScreenViewState(isDialogVisible = false))
                    sendEvent(StartScreenViewEvent.NavigateToTimerScreen)
                } else {
                    sendEvent(StartScreenViewEvent.MakeToast(R.string.time_limit))
                }
            }
        }
    }

    private fun sendNewTimeValue(time: Int) = Unit

}