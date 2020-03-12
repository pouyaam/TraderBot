package tv.pouyaam.bottrader.network.retrofit.coinbase

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tv.pouyaam.bottrader.network.retrofit.RetrofitProvider

class CoinbaseRetrofitProviderImpl(baseUrl: String) : RetrofitProvider(baseUrl) {

    init {
        okHttpClient = OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
        ).build()
        retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

    override fun provideRetrofit(): Retrofit = retrofit
    override fun provideOkHttp(): OkHttpClient = okHttpClient

}