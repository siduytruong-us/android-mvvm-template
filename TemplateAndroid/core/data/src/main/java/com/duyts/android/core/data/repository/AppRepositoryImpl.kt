package com.duyts.android.core.data.repository


import com.duyts.android.common.network.Dispatcher
import com.duyts.android.common.network.NiaDispatchers
import com.duyts.android.network.AppNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
	@Dispatcher(NiaDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
	private val networkDataSource: AppNetworkDataSource,
) : AppRepository {
	override fun loadMessage(): Flow<String> = flow {
		emit(networkDataSource.getMessage())
	}.flowOn(ioDispatcher)

}