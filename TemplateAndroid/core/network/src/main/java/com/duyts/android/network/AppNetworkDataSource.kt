package com.duyts.android.network

interface AppNetworkDataSource {
	suspend fun getMessage(): String
}