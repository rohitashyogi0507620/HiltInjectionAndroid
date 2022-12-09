package  com.yogify.hiltinjectionandroid.di

import com.yogify.hiltinjectionandroid.Models.Product
import com.yogify.hiltinjectionandroid.di.UserConstant.PRODUCTS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface UserAPI {


    @GET(PRODUCTS)
    suspend fun getproduct(): Response<List<Product>>

}