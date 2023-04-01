package com.example.examplemvvmepo.features.listusers.router

import androidx.navigation.NavController
import com.example.examplemvvmepo.features.listusers.FragmentListUserDirections
import com.example.examplemvvmepo.util.view.BaseRouter

class RouterListUser(navController: NavController) : BaseRouter(navController) {

   fun navigateCreationUser(){
       val action = FragmentListUserDirections.actionFragmentListUserToFragmentUserCrud()
       navController.navigate(action)
   }
}