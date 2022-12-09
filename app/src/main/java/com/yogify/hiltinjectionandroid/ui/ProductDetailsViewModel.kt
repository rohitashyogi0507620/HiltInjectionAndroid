package com.yogify.hiltinjectionandroid.ui

import androidx.lifecycle.ViewModel
import com.yogify.hiltinjectionandroid.repository.UserReposotory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(var userReposotory: UserReposotory) :
    ViewModel() {
}