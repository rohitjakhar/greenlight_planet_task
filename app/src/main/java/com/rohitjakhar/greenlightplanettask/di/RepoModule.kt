package com.rohitjakhar.greenlightplanettask.di

import com.rohitjakhar.greenlightplanettask.data.repo.SaleDataRepoImpl
import com.rohitjakhar.greenlightplanettask.domain.repo.SaleDataRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindSaleDataRepo(
        saleDataRepoImpl: SaleDataRepoImpl
    ): SaleDataRepo
}
