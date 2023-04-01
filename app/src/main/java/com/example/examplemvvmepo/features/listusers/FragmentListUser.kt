package com.example.examplemvvmepo.features.listusers

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.examplemvvmepo.databinding.FragmentListUserBinding
import com.example.examplemvvmepo.features.listusers.adapter.ListUserAdapter
import com.example.examplemvvmepo.features.listusers.router.RouterListUser
import com.example.examplemvvmepo.features.listusers.viewmodel.GetListUserViewModel
import com.example.examplemvvmepo.util.view.BaseFragment
import com.example.examplemvvmepo.util.view.launchAndCollect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentListUser : BaseFragment<FragmentListUserBinding>() {


    private val viewModelListUser:GetListUserViewModel by viewModels()
    private val adapterListUser: ListUserAdapter =ListUserAdapter()
    private lateinit var listRouter : RouterListUser

    override fun createFragment() {

    }

    override fun initView() {
        listRouter = RouterListUser(findNavController())
        binding.recyclerUser.adapter = adapterListUser
    }

    override fun initListeners() {
        binding.floatingActionButton.setOnClickListener {
            listRouter.navigateCreationUser()
        }
    }

    override fun initObservables() {
       viewLifecycleOwner.launchAndCollect(viewModelListUser.state){state ->
           handleUI(state)
       }
    }

    private fun handleUI(state: GetListUserViewModel.UIState) {
        state.listUser?.let {listUsers->
            adapterListUser.submitList(listUsers)
        }
    }

    override fun getParametersFragment() {

    }

    override fun callDataSource() {
        viewModelListUser.getListUser()
    }

    override fun getViewBinding(): FragmentListUserBinding =
        FragmentListUserBinding.inflate(layoutInflater)

}
