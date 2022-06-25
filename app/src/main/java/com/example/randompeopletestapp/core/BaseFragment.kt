package com.example.randompeopletestapp.core

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding, VS : AppStateEntity, VM : BaseViewModel<VS>> :
    Fragment() {

}