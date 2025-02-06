package edu.ucne.samueljavier_p1_ap2.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.samueljavier_p1_ap2.data.local.database.ParcialDb


import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(
            appContext,
            ParcialDb::class.java,
            "Parcial.db"
        ).fallbackToDestructiveMigration()
            .build()
    @Provides
    fun ProvideDao(parcialDb: ParcialDb) = parcialDb.Dao()
}