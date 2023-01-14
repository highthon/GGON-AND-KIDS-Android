package com.example.jjol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jjol.navigation.JjolNavigation
import com.example.jjol.ui.ChallengeScreen
import com.example.jjol.ui.CreateChallenge
import com.example.jjol.ui.theme.JJOLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseApp()
        }
    }
}

@Composable
fun BaseApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = JjolNavigation.Login.route) {
        composable(JjolNavigation.Login.route) {
            LoginScreen(navController)
        }
        composable(JjolNavigation.Home.route) {
            HomeScreen(navController)
        }
        composable(JjolNavigation.Match.route) {
            MatchScreen(navController)
        }
        composable(JjolNavigation.MatchSuccess.route) {
            MatchSuccessScreen(navController)
        }
        composable(JjolNavigation.Challenge.route) {
            ChallengeScreen(navController)
        }
        composable(JjolNavigation.CreateChallenge.route) {
            CreateChallenge(navController)
        }
        composable(JjolNavigation.JoinChallenge.route) {
            JoinChallenge(navController)
        }
    }
}