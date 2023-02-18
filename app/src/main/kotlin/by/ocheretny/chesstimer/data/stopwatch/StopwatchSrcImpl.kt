package by.ocheretny.chesstimer.data.stopwatch

import by.ocheretny.chesstimer.models.Black
import by.ocheretny.chesstimer.models.Player
import by.ocheretny.chesstimer.models.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

private const val SECOND = 1000L

class StopwatchSrcImpl @Inject constructor(
    override val coroutineContext: CoroutineContext,
) : StopwatchSrc, CoroutineScope {

    private val blackPlayerTime = MutableStateFlow(0)
    private val whitePlayerTime = MutableStateFlow(0)

    private var timerJob: Job? = null

    override fun observeWhiteTime(player: Player): Flow<Int> = when (player) {
        Black -> blackPlayerTime
        White -> whitePlayerTime
    }

    private fun launchTimerJob(player: Player) = launch {
        while (isActive) {
            delay(SECOND)
            mutatePlayerFlow(player) { stateFlow -> stateFlow.update { it - 1 } }
        }
    }

    override fun setTime(seconds: Int) {
        mutatePlayerFlow(White) { stateFlow -> stateFlow.update { seconds } }
        mutatePlayerFlow(Black) { stateFlow -> stateFlow.update { seconds } }
    }

    override fun start(player: Player) {
        timerJob = launchTimerJob(player)
    }

    override fun pause(player: Player) {
        timerJob = null
    }

    override fun stop(player: Player) {
        timerJob = null
    }

    override fun defineWinner(): Flow<Player> {
        TODO("Not yet implemented")
    }

    private fun mutatePlayerFlow(player: Player, block: (MutableStateFlow<Int>) -> Unit) =
        when (player) {
            Black -> block(blackPlayerTime)
            White -> block(whitePlayerTime)
        }

}