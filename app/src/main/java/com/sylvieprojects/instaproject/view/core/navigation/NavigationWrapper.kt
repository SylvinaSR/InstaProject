package com.sylvieprojects.instaproject.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sylvieprojects.instaproject.view.auth.login.LoginScreen
import com.sylvieprojects.instaproject.view.auth.signUp.SignUpScreen
import com.sylvieprojects.instaproject.view.principal.PrincipalScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(
                navigateToLogin = {
                    navController.navigate(Principal)
                },
                navigateToSignUp = {
                navController.navigate(SignUp)
            })
        }
        composable<SignUp> {
            SignUpScreen(navigateBack = {
                navController.popBackStack()
            })
        }
        composable<Principal> {
            PrincipalScreen()
        }
    }
}