package com.example.randompeopletestapp.presentation.main.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randompeopletestapp.R
import com.example.randompeopletestapp.core.BaseFragment
import com.example.randompeopletestapp.databinding.FragmentListBinding
import com.example.randompeopletestapp.domain.entity.appstate.LocalUsersList
import com.example.randompeopletestapp.presentation.main.adapter.UsersListAdapter
import com.example.randompeopletestapp.presentation.main.viewmodel.MainViewModel
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

class ListFragment : BaseFragment<FragmentListBinding, MainViewState, MainViewModel>(
    R.layout.fragment_list
) {
    override val viewModel: MainViewModel by viewModels()

    private var adapter: UsersListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
    }

    override fun renderSuccess(data: MainViewState) {
        if (data is LocalUsersList) adapter?.submitList(data.usersList)

        super.renderSuccess(data)
    }

    private fun initRecycler() {
        adapter = UsersListAdapter { viewModel.onUserClicked(it) }

        binding.run {
            usersList.adapter = adapter
            usersList.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}