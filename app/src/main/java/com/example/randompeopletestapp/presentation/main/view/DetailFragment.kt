package com.example.randompeopletestapp.presentation.main.view

import androidx.fragment.app.activityViewModels
import com.example.randompeopletestapp.R
import com.example.randompeopletestapp.core.BaseFragment
import com.example.randompeopletestapp.data.image.loadImage
import com.example.randompeopletestapp.databinding.FragmentDetailBinding
import com.example.randompeopletestapp.presentation.main.viewmodel.MainViewModel
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

class DetailFragment : BaseFragment<FragmentDetailBinding, MainViewState, MainViewModel>(
    R.layout.fragment_detail
) {

    override val viewModel: MainViewModel by activityViewModels()

    override fun renderSuccess(data: MainViewState) {
        data.currentUser?.let {
            binding.run {
                loadImage(it.largePic, image)
                title.text = it.title
                first.text = it.first
                last.text = it.last
                username.text = it.username
                password.text = it.password
                street.text = it.street
                city.text = it.city
                state.text = it.state
                postcode.text = it.postcode
                cell.text = it.cell
                email.text = it.email
            }
        }

        super.renderSuccess(data)
    }

}