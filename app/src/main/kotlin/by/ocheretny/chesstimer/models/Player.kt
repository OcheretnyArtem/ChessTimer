package by.ocheretny.chesstimer.models

sealed class Player {
    object White : Player()
    object Black : Player()
}