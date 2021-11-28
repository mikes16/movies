package com.gamecast.data.di.modules

import com.gamecast.data.BuildConfig
import com.gamecast.data.remote.MoviesApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/")
            .client(okHttpClient)
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun providesMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun providesOkHttp(interceptors: ArrayList<Interceptor>): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .followRedirects(false)

        interceptors.forEach {
            clientBuilder.addInterceptor(it)
        }
        return clientBuilder.build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideInterceptors(): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
        interceptors.add(loggingInterceptor)

        // Intercept the request and add the query params needed for all requests.
        val tokenInterceptor = Interceptor {
            var original = it.request()
            val urlBuilder = original.url.newBuilder()
            urlBuilder.addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            urlBuilder.addQueryParameter("language", "en-US")
            original = original.newBuilder().url(urlBuilder.build()).build()
            it.proceed(original)
        }
        interceptors.add(tokenInterceptor)

        return interceptors
    }
}