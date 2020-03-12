package tv.pouyaam.bottrader.network.retrofit.cryptocompare

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tv.pouyaam.bottrader.network.interceptor.cryptocompare.ApiKeyInterceptor
import tv.pouyaam.bottrader.network.retrofit.RetrofitProvider

class CryptoCompareRetrofitProviderImpl(
    baseUrl: String,
    private val apiKeyInterceptor: ApiKeyInterceptor
) : RetrofitProvider(baseUrl) {

    init {
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                    .setLevel(HttpLoggingInterceptor.Level.HEADERS)
            )
            .addInterceptor(apiKeyInterceptor)
            .build()

        retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            GsonConverterFactory.create()).client(okHttpClient).build()
    }

    override fun provideRetrofit(): Retrofit = retrofit
    override fun provideOkHttp(): OkHttpClient = okHttpClient
}