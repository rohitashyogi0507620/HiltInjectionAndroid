package com.yogify.hiltinjectionandroid.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogify.hiltinjectionandroid.repository.UserReposotory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val userReposotory: UserReposotory) : ViewModel() {

    var productList = userReposotory.producList

    fun getproducts() {
        viewModelScope.launch {
            userReposotory.getproducts()
        }
    }
}