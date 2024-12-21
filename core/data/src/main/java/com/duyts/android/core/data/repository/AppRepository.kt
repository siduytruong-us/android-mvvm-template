package com.duyts.android.core.data.repository

import kotlinx.coroutines.flow.Flow

interface AppRepository {
	fun loadMessage(): Flow<String>
}