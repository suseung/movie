package com.movie.home

import androidx.lifecycle.viewModelScope
import com.movie.base.MVIViewModel
import com.movie.domain.base.ApiResult
import com.movie.domain.base.asResult
import com.movie.domain.usecase.GetMovieDetailsByIdUseCase
import com.movie.home.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieDetailsByIdUseCase: GetMovieDetailsByIdUseCase
) : MVIViewModel<HomeIntent, HomeState, HomeEffect>() {

    private val homeResult = loadDataSignal
        .flatMapLatest { getMovieDetailsByIdUseCase(500).asResult() }
        .stateIn(viewModelScope, SharingStarted.Lazily, ApiResult.Loading)


    override fun createInitialState() = HomeState.Loading

    init {
        viewModelScope.launch {
            homeResult.collect { apiResult ->
                setState {
                    when (apiResult) {
                        is ApiResult.Loading -> HomeState.Loading
                        is ApiResult.Success -> {
                            val data = apiResult.data.toUiModel()
                            HomeState.Success(
                                movieDetailInfo = data
                            )
                        }
                        is ApiResult.Error -> HomeState.Error
                    }
                }
            }
        }
    }
    override suspend fun processIntent(intent: HomeIntent) {

    }
}
