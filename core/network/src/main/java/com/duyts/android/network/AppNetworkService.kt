package com.duyts.android.network

import retrofit2.Response
import retrofit2.http.GET

interface AppNetworkService {
	@GET("/example/get")
	suspend fun getMessage(): Response<String>
}