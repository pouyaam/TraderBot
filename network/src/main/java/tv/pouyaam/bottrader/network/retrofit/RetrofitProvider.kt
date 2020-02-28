package tv.pouyaam.bottrader.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface RetrofitProvider {
    fun provideRetrofit(): Retrofit
    fun provideOkHttp() : OkHttpClient
}