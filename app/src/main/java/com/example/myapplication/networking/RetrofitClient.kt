
import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun createRetrofit(
        converterFactory: Converter.Factory = GsonConverterFactory.create()
    ): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request()
                val response = it.proceed(request)
                val loggerTag = "OkHttp"
                Log.d(loggerTag, "request: url ${request.url()}")
                Log.d(loggerTag, "request: headers ${request.headers().toMultimap()}")
                Log.d(loggerTag, "request: body ${request.body()}")
                Log.d(loggerTag, "request: response $response")
                return@addInterceptor response
            }.build()

        return Retrofit.Builder()
            .baseUrl("https://apnabiz-dev.esthenos.com")
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    inline fun <reified T> createService(
        converterFactory: Converter.Factory = GsonConverterFactory.create()
    ): T = createRetrofit(converterFactory).create(T::class.java)
}