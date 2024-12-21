package com.duyts.android.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.duyts.android.home.HOME_ROUTE
import com.duyts.android.home.homeScreen


@Composable
fun AppNavigation() {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = HOME_ROUTE) {
		homeScreen()
	}
}