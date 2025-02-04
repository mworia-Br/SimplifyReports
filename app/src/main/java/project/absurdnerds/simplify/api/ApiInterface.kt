package project.absurdnerds.simplify.api

import com.google.gson.GsonBuilder
import project.absurdnerds.simplify.data.request.*
import project.absurdnerds.simplify.data.response.*
import project.absurdnerds.simplify.utils.AppConfig
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface {

    companion object{
        operator fun invoke(): ApiInterface {

            var gson = GsonBuilder()
                .setLenient()
                .create()

            return Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiInterface::class.java)
        }
    }

    // Get User
    @Headers("Content-Type: application/json")
    @GET("profile/")
    suspend fun putUser(
        @Body putPhoneRequest: ProfilePutRequest
    ): Response<Void>

    // Get User
    @Headers("Content-Type: application/json")
    @GET("profile/")
    fun getProfile(
        @Body commonPhoneRequest: CommonPhoneRequest
    ): Call<ProfilePostResponse>

    // Profile
    @Headers("Content-Type: application/json")
    @PUT("profile/")
    fun putProfileToken(
        @Body putPhoneRequest: ProfilePutRequest
    ): Call<Void>

    @Headers("Content-Type: application/json")
    @POST("profile/")
    fun postProfileData(
        @Body profileRequest: ProfileRequest
    ): Call<ProfilePostResponse>

    // Ambulance
    @Headers("Content-Type: application/json")
    @POST("ambulance/")
    fun postAmbulanceData(
        @Body ambulancePostRequest: AmbulancePostRequest
    ): Call<AmbulanceRequest>

    // Fire
    @Headers("Content-Type: application/json")
    @POST("fire/")
    fun postFireData(
        @Body fireRequest: FireRequest
    ): Call<FirePostResponse>

    // Police
    @Headers("Content-Type: application/json")
    @POST("police/")
    fun postPoliceData(
        @Body policePostRequest: PolicePostRequest
    ): Call<PolicePostResponse>


    @Headers("Content-Type: application/json")
    @GET("ambulance/")
    fun getAmbulance(
        @Query("phone") phone: String
    ) : Call<AmbulanceGetResponse>

    @Headers("Content-Type: application/json")
    @GET("fire/")
    fun getFire(
        @Query("phone") phone: String
    ) : Call<FireGetResponse>

    @Headers("Content-Type: application/json")
    @GET("police/")
    fun getPolice(
        @Query("phone") phone: String
    ) : Call<PoliceGetResponse>

}