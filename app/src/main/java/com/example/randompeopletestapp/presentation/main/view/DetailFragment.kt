package com.example.randompeopletestapp.presentation.main.view

import androidx.databinding.ViewDataBinding
import com.example.randompeopletestapp.core.BaseFragment
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.presentation.main.viewmodel.MainViewModel
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

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