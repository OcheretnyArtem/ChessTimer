package by.ocheretny.chesstimer.screens.startScreen

import by.ocheretny.chesstimer.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartScreenViewModel @Inject constructor() :
    BaseViewModel<StartScreenViewState, StartScreenViewEvent, StartScreenViewAction>() {

    override val initialViewState: StartScreenViewState = StartScreenViewState()

    override fun processAction(action: StartScreenViewAction) = when (action) {
        is StartScreenViewAction.DialogVisibilityChanged -> {
            updateViewState(StartScreenViewState(action.isDialogVisible))
        }
        StartScreenViewAction.NavigateToTimerScreen -> {

        }
    }

}