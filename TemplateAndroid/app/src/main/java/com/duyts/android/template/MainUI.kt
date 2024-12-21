package com.duyts.android.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.duyts.android.template.navigation.AppNavigation

@Composable
fun MainUI() {
	Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(innerPadding)
		) {
			AppNavigation()
		}
	}
}