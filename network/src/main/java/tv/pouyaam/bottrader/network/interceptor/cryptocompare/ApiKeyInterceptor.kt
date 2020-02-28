package tv.pouyaam.bottrader.network.interceptor.cryptocompare

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    //TODO: Later on add a repository and token pool in order to rotate between tokens
    private val apiKey = "e9a54247cc9d6a61ad5a1bb14305079fc622a63f2f35f931b27b3b33cae4bbd0"
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request
            .newBuilder()
            .removeHeader("authorization")
            .addHeader("authorization", "Apikey $apiKey")
            .build()

        return chain.proceed(request)
    }
}