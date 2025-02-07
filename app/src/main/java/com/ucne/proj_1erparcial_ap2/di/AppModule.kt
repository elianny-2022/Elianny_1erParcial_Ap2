package com.ucne.proj_1erparcial_ap2.di

import android.content.Context
import androidx.room.Room
import com.ucne.proj_1erparcial_ap2.data.PrestamosDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): PrestamosDb {
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            "Prestamos.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

   @Singleton
    @Provides
    fun providesOcupacionDao(db: PrestamosDb) = db.prestamoDao
}