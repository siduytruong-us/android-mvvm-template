package com.duyts.android.network.di

import com.duyts.android.network.AppNetworkDataSource
import com.duyts.android.network.datasource.DemoDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkDataSourceModule {
	@Binds
	abstract fun binds(impl: DemoDataSourceImpl): AppNetworkDataSource
}