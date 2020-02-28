package tv.pouyaam.bottrader.network.retrofit.cryptocompare

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tv.pouyaam.bottrader.network.interceptor.cryptocompare.ApiKeyInterceptor
import tv.pouyaam.bottrader.network.retrofit.RetrofitProvider

class CryptoCompareRetrofitProviderImpl(private val apiKeyInterceptor: ApiKeyInterceptor) : RetrofitProvider {
    private val retrofit: Retrofit
    private val okHttpClient: OkHttpClient
        get() {
            return OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                        .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                )
                .addInterceptor(apiKeyInterceptor)
                .build()
        }

    init {
        retrofit = Retrofit.Builder().baseUrl("https://min-api.cryptocompare.com/").addConverterFactory(
            GsonConverterFactory.create()).client(okHttpClient).build()
    }

    override fun provideRetrofit(): Retrofit = retrofit
    override fun provideOkHttp(): OkHttpClient = okHttpClient
}