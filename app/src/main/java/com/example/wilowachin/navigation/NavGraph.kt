package com.example.wilowachin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wilowachin.presentation.screens.FirstScreen
import com.example.wilowachin.presentation.screens.JournalEditorScreen
import com.example.wilowachin.presentation.screens.ShareJournalScreen
import com.example.wilowachin.presentation.screens.SignUpScreen
import com.example.wilowachn.ui.screens.LoginScreen
import com.example.wilowachin.presentation.screens.MyJournalsScreen
import com.example.wilowachin.presentation.screens.SharedJournalScreen
import com.example.wilowachin.presentation.screens.WelcomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen") { FirstScreen(onLoginClick = { navController.navigate("loginScreen") }, onSignUpClick = { navController.navigate("signUpScreen") }) }
        composable("loginScreen") { LoginScreen(navController = navController, onForgotPasswordClick = { /* TODO: Implement */ }, onLoginClick = { email, password -> /* TODO: Implement auth and navigate to welcome */ navController.navigate("welcomeScreen") }) }
        composable("signUpScreen") { SignUpScreen(navController = navController, onSignUpClick = { email, username, password, confirmPassword -> /* TODO: Implement signup and navigate to welcome */ navController.navigate("welcomeScreen") }) }
        composable("welcomeScreen") { WelcomeScreen(navController = navController) }
        composable("myjournals") { MyJournalsScreen(navController = navController) }
        composable("journalEditor/{journalId}") { backStackEntry ->
            val journalId = backStackEntry.arguments?.getString("journalId")?.toIntOrNull() ?: 0
            JournalEditorScreen(
                onSave = { title, content ->
                    /* TODO: Save journal */
                    navController.popBackStack()
                },
                onDelete = {
                    /* TODO: Delete journal */
                    navController.popBackStack()
                },
                onBack = { navController.popBackStack() },
                journalId = journalId,
                navController = TODO()
            )
        }
        composable("sharedJournalPage") { SharedJournalScreen(navController = navController) }
        composable("shareJournalScreen") { ShareJournalScreen() }
    }
}
