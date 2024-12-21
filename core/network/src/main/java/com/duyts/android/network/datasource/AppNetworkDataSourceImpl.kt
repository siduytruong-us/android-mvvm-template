package com.duyts.android.network.datasource

import com.duyts.android.common.network.Dispatcher
import com.duyts.android.common.network.NiaDispatchers
import com.duyts.android.common.network.ext.safeApiCall
import com.duyts.android.network.AppNetworkDataSource
import com.duyts.android.network.AppNetworkService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AppNetworkDataSourceImpl @Inject constructor(
	private val networkApi: AppNetworkService,
	@Dispatcher(NiaDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : AppNetworkDataSource {

	override suspend fun getMessage(): String = safeApiCall {
		delay(2000)
		return@safeApiCall networkApi.getMessage()
	}
}