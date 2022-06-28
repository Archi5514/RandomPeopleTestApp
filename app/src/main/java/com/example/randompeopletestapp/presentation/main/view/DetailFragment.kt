package com.example.randompeopletestapp.presentation.main.view

import androidx.fragment.app.viewModels
import com.example.randompeopletestapp.R
import com.example.randompeopletestapp.core.BaseFragment
import com.example.randompeopletestapp.data.image.loadImage
import com.example.randompeopletestapp.databinding.FragmentDetailBinding
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.presentation.main.viewmodel.MainViewModel
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

class DetailFragment : BaseFragment<FragmentDetailBinding, MainViewState, MainViewModel>(
    R.layout.fragment_detail
) {

    override val viewModel: MainViewModel by viewModels()

    override fun renderSuccess(data: MainViewState) {
        if (data is LocalUser) binding.run {
            loadImage(data.mediumPic, image)
            title.text = data.title
            first.text = data.first
            last.text = data.last
            username.text = data.username
            password.text = data.password
            street.text = data.street
            city.text = data.city
            state.text = data.state
            postcode.text = data.postcode
            cell.text = data.cell
            email.text = data.email
        }

        super.renderSuccess(data)
    }

}