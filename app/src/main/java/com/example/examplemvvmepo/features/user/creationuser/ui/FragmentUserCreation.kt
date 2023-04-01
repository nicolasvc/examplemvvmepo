package com.example.examplemvvmepo.features.user.creationuser.ui

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.UserDomain
import com.example.examplemvvmepo.databinding.FragmentCrudUserBinding
import com.example.examplemvvmepo.features.user.creationuser.viewmodel.ViewModelCreationUser
import com.example.examplemvvmepo.util.view.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentUserCreation : BaseFragment<FragmentCrudUserBinding>() {

    private val creationViewModel: ViewModelCreationUser by viewModels()


    override fun createFragment() {

    }


    override fun initView() {

    }

    override fun initListeners() {
        binding.button.setOnClickListener {
            creationViewModel.createUser(
                UserDomain(
                    0,
                    binding.editTextTextPersonName.text.toString(),
                    binding.editTextTextPersonName2.text.toString(),
                    Integer.parseInt(binding.editTextTextPersonName3.text.toString())
                )
            )
            findNavController().navigateUp()
        }
    }

    override fun initObservables() {

    }

    override fun getParametersFragment() {

    }

    override fun callDataSource() {

    }

    override fun getViewBinding(): FragmentCrudUserBinding =
        FragmentCrudUserBinding.inflate(layoutInflater)

}
