package com.taylorm.s169382.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*
Dagger Hilt module that provides application-level dependencies.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule