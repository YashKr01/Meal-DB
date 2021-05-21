package com.example.meals.di

import android.content.Context
import androidx.room.Room
import com.example.meals.api.ApiInterface
import com.example.meals.database.MealDao
import com.example.meals.database.MealDatabase
import com.example.meals.utils.Constants.Companion.BASE_URL
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(@ApplicationContext context: Context): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MealDatabase =
        Room.databaseBuilder(context, MealDatabase::class.java, "MEAL").build()

    @Singleton
    @Provides
    fun provideDao(mealDatabase: MealDatabase): MealDao =
        mealDatabase.mealDao()

}