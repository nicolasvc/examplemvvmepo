package com.example.examplemvvmepo.features.listusers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.UserDomain
import com.example.usecases.user.CreateUserUseCase
import com.example.usecases.user.GetListUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetListUserViewModel @Inject constructor(
    private val getListUser: GetListUserUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state: StateFlow<UIState> get() = _state.asStateFlow()


    fun getListUser() = viewModelScope.launch {
        getListUser.invoke().catch { }.collect { users ->
            _state.update { UIState(listUser = users) }
        }
    }


    private fun setLoading(boolean: Boolean) {
        _state.update { UIState(loading = boolean) }
    }


    data class UIState(
        val error: Error? = null,
        val loading: Boolean = false,
        val listUser: List<UserDomain>? = null
    )


}