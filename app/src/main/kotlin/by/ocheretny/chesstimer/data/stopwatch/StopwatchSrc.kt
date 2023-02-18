package by.ocheretny.chesstimer.data.stopwatch

import by.ocheretny.chesstimer.models.Player
import kotlinx.coroutines.flow.Flow

interface StopwatchSrc {

    fun observeWhiteTime(player: Player): Flow<Int>

    fun setTime(seconds: Int)

    fun start(player: Player)

    fun pause(player: Player)

    fun stop(player: Player)

    fun defineWinner(): Flow<Player>
}
