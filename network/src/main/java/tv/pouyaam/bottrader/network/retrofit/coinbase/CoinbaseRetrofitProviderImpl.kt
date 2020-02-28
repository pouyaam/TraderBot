package tv.pouyaam.bottrader.network.retrofit.coinbase

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tv.pouyaam.bottrader.network.retrofit.RetrofitProvider

class CoinbaseRetrofitProviderImpl():
    RetrofitProvider {

    private val retrofit: Retrofit
    private val okHttpClient: OkHttpClient
        get() {
            return OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                    .setLevel(HttpLoggingInterceptor.Level.HEADERS)
            ).build()
        }

    init {
        retrofit = Retrofit.Builder().baseUrl("https://api.coinbase.com/").addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

    override fun provideRetrofit(): Retrofit = retrofit
    override fun provideOkHttp(): OkHttpClient = okHttpClient

}