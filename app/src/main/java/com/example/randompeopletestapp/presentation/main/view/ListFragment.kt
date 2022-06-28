package com.example.randompeopletestapp.presentation.main.view

import com.example.randompeopletestapp.R
import com.example.randompeopletestapp.core.BaseFragment
import com.example.randompeopletestapp.databinding.FragmentListBinding
import com.example.randompeopletestapp.domain.entity.appstate.LocalUsersList
import com.example.randompeopletestapp.presentation.main.viewmodel.MainViewModel
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

class ListFragment : BaseFragment<FragmentListBinding, MainViewState, MainViewModel>(
    R.layout.fragment_list
) {
    override val viewModel: MainViewModel
        get() = TODO("Not yet implemented")

    override fun renderSuccess(data: MainViewState) {
        if (data is LocalUsersList) //submitList
            super.renderSuccess(data)
    }
}