package com.example.randompeopletestapp.presentation.main.view

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.randompeopletestapp.R
import com.example.randompeopletestapp.core.BaseFragment
import com.example.randompeopletestapp.data.image.loadImage
import com.example.randompeopletestapp.databinding.FragmentDetailBinding
import com.example.randompeopletestapp.databinding.ModalDialogPictureBinding
import com.example.randompeopletestapp.presentation.main.viewmodel.MainViewModel
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

class DetailFragment : BaseFragment<FragmentDetailBinding, MainViewState, MainViewModel>(
    R.layout.fragment_detail
) {

    override val viewModel: MainViewModel by activityViewModels()

    private val dialogBinding: ModalDialogPictureBinding by lazy {
        ModalDialogPictureBinding.inflate(layoutInflater)
    }
    private val dialog: Dialog by lazy { Dialog(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog.setContentView(dialogBinding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.image.setOnClickListener {
            onImageClicked()
        }
    }

    override fun renderSuccess(data: MainViewState) {
        data.currentUser?.let {
            binding.run {
                loadImage(it.largePic, image)
                this.data = it
            }
        }

        super.renderSuccess(data)
    }

    private fun onImageClicked() {
        loadImage(viewModel.currentImage, dialogBinding.largeImage)
        dialog.show()
    }
}