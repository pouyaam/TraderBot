package tv.pouyaam.bottrader.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit

abstract class RetrofitProvider(private val baseUrl: String) {
    protected lateinit var retrofit: Retrofit
    protected lateinit var okHttpClient: OkHttpClient

    abstract fun provideRetrofit(): Retrofit
    abstract fun provideOkHttp() : OkHttpClient
}