package  com.yogify.hiltinjectionandroid.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yogify.hiltinjectionandroid.Models.NetworkResult
import com.yogify.hiltinjectionandroid.Models.Product
import com.yogify.hiltinjectionandroid.di.UserAPI
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class UserReposotory @Inject constructor(private val userAPI: UserAPI) {

    private val _productList = MutableLiveData<NetworkResult<List<Product>>>()
    val producList get() = _productList

    suspend fun getproducts() {

        val response = userAPI.getproduct()
        Log.d("Response", response.toString())

        if (response.isSuccessful && response.body() != null) {
            _productList.postValue(NetworkResult.Success(response.body()))

        } else if (response.errorBody() != null) {
            _productList.postValue(NetworkResult.Error("Something Went worng"))
        } else {
            _productList.postValue(NetworkResult.Error("Something Went worng"))
        }
    }
}