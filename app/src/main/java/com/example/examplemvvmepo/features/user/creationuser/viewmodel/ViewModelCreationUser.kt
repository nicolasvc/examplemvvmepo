package com.example.examplemvvmepo.features.user.creationuser.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.UserDomain
import com.example.usecases.user.CreateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModelCreationUser @Inject constructor(
    private val createUserUseCase: CreateUserUseCase
) :ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state: StateFlow<UIState> get() = _state.asStateFlow()


    fun createUser(user:UserDomain) = viewModelScope.launch {
        createUserUseCase.invoke(user)
    }


    private fun setLoading(boolean: Boolean) {
        _state.update { UIState(loading = boolean) }
    }



    data class UIState(
        val error: Error? = null,
        val loading: Boolean = false
    )
}