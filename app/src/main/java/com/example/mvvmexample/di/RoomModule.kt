package com.example.mvvmexample.di

import androidx.room.Room
import android.content.Context
import com.example.mvvmexample.data.database.CardDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val CARD_DATABASE_NAME = "card_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CardDatabase::class.java,CARD_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(db: CardDatabase) = db.getCardDao()


}