package com.duyts.android.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duyts.android.common.Resource.Resource
import com.duyts.android.common.Resource.asResource
import com.duyts.android.core.data.repository.AppRepository
import com.duyts.android.core.data.repository.AppRepositoryImpl
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
	private val appRepository: AppRepository,
) : ViewModel() {
	private val _state: StateFlow<HomeScreenState> = load().stateIn(
		scope = viewModelScope,
		started = SharingStarted.WhileSubscribed(5_000),
		HomeScreenState.Loading
	)

	val state: StateFlow<HomeScreenState> = _state

	private fun load(): Flow<HomeScreenState> =
		appRepository.loadMessage().asResource().map { result ->
			println(Thread.currentThread().name)
			when (result) {
				is Resource.Error -> HomeScreenState.Error(result.message)
				Resource.Loading -> HomeScreenState.Loading
				is Resource.Success -> HomeScreenState.Success(greeting = result.data)
			}
		}

}

sealed class HomeScreenState() {
	data class Success(val greeting: String) : HomeScreenState()
	data object Loading : HomeScreenState()
	data class Error(val error: String) : HomeScreenState()
}