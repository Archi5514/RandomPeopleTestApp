package com.example.randompeopletestapp.presentation.main

import androidx.databinding.ViewDataBinding
import com.example.randompeopletestapp.core.BaseFragment
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser

class DetailFragment(layoutID: Int) : BaseFragment<ViewDataBinding, MainViewState, MainViewModel>(
    layoutID
) {

    override val viewModel: MainViewModel
        get() = TODO("Not yet implemented")

    override fun renderSuccess(data: MainViewState) {
        if (data is LocalUser) //display info about local user
            super.renderSuccess(data)
    }

}