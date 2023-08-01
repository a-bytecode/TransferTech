package remote

import bankacc.TurnoverAcc
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://testapi.io/api/"

private val client:OkHttpClient = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val newRequest: Request = chain.request().newBuilder()
            .build()
        chain.proceed(newRequest) }.build()

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface TurnoverApiService{

    @GET("sf/v1/turnovers")

    suspend fun getTurnovers(@Query("accID") accID: String) : List<TurnoverAcc>

    object UserApi {
        val retrofitService: TurnoverApiService by lazy { retrofit.create(TurnoverApiService::class.java) }
    }

}