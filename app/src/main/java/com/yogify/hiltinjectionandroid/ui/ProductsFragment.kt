package com.yogify.hiltinjectionandroid.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.yogify.hiltinjectionandroid.Models.NetworkResult
import com.yogify.hiltinjectionandroid.R
import com.yogify.hiltinjectionandroid.databinding.FragmentProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private val viewModel : ProductsViewModel by viewModels()

    lateinit var binding: FragmentProductsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.btnLoadData.setOnClickListener {
            viewModel.getproducts()
        }
        viewModel.productList.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {}
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }
        }

    }

}