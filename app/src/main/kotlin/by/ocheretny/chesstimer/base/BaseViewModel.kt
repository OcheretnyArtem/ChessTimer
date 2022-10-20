package by.ocheretny.chesstimer.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<VS : ViewState, VE : ViewEvent, VA : ViewAction> : ViewModel() {

    protected abstract val initialViewState: VS
    protected abstract fun processAction(action: VA)

    protected var lastViesState: VS = initialViewState

    private val _viewState = MutableStateFlow(initialViewState)
    val viewState = _viewState.asStateFlow()

    private val _viewEvents = Channel<VE?>(Channel.BUFFERED)
    val viewEvents = _viewEvents.receiveAsFlow()

    private val _viewActions = Channel<VA>(Channel.BUFFERED)

    init {
        viewModelScope.launch {
            _viewActions.consumeEach { action ->
                processAction(action)
            }
        }
    }

    protected open fun updateViewState(state: VS) {
        _viewState.value = state
        lastViesState = state
    }

    protected fun sendEvent(event: VE) = viewModelScope.launch {
        _viewEvents.send(null)
        _viewEvents.send(event)
    }

    fun applyAction(action: VA) = viewModelScope.launch {
        _viewActions.send(action)
    }

}
