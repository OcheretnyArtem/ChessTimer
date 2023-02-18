package by.ocheretny.chesstimer.di

import by.ocheretny.chesstimer.data.stopwatch.StopwatchSrc
import by.ocheretny.chesstimer.data.stopwatch.StopwatchSrcImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface AppModule {

    @Binds
    @ViewModelScoped
    fun bindChessTimeRepository(chessTimeRepository: StopwatchSrcImpl): StopwatchSrc

}
