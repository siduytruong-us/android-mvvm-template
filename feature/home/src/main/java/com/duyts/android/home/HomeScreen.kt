package com.duyts.android.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(
	viewModel: HomeScreenViewModel = hiltViewModel(),
) {
	val state = viewModel.state.collectAsStateWithLifecycle().value
	when (state) {
		is HomeScreenState.Loading -> {
			CircularProgressIndicator()
		}

		is HomeScreenState.Error -> ErrorContent(state)
		is HomeScreenState.Success -> HomeContent(state)
	}
}

@Composable
private fun HomeContent(state: HomeScreenState.Success) {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(MaterialTheme.colorScheme.background),
		contentAlignment = Alignment.Center
	) {
		Text(state.greeting)
	}
}

@Composable
private fun ErrorContent(state: HomeScreenState.Error) {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(MaterialTheme.colorScheme.background),
		contentAlignment = Alignment.Center
	) {
		Text(state.error)
	}
}


@Preview
@Composable
fun HomeContentPreview() {
	HomeContent(HomeScreenState.Success("Welcome home!"))
}

@Preview
@Composable
fun ErrorContentPreview() {
	ErrorContent(HomeScreenState.Error("Error message!"))
}