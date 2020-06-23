package com.nikitafrolov.stackoverflow.common.di.application

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.nikitafrolov.stackoverflow.BuildConfig
import com.nikitafrolov.stackoverflow.V_2_2
import com.nikitafrolov.stackoverflow.question.network.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getMapper(): ObjectMapper = ObjectMapper()
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    @Singleton
    @Provides
    fun getRetrofit(mapper: ObjectMapper): Retrofit = Retrofit.Builder()
        .baseUrl("${BuildConfig.ENDPOINT}$V_2_2/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(JacksonConverterFactory.create(mapper))
        .build()

    @Singleton
    @Provides
    fun getStackoverflowApi(retrofit: Retrofit): StackoverflowApi =
        retrofit.create(StackoverflowApi::class.java)
}