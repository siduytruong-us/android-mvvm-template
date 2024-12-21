package com.duyts.android.core.data.di

import com.duyts.android.core.data.repository.AppRepository
import com.duyts.android.core.data.repository.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

	@Binds
	abstract fun provideRepository(
		appRepository: AppRepositoryImpl,
	): AppRepository
}