package com.example.randompeopletestapp.core

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding, D : AppStateEntity, VM : BaseViewModel<D>> :
    Fragment() {



}