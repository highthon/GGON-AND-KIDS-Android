package com.example.jjol.navigation

import com.example.jjol.Jjol

sealed class JjolNavigation(val route: String) {

    object Login : JjolNavigation("login")

    object Home : JjolNavigation("home")

    object Challenge : JjolNavigation("challenge")

    object JoinChallenge : JjolNavigation("join challenge")

    object CreateChallenge : JjolNavigation("create challenge")

    object Match : JjolNavigation("match")

    object MatchSuccess : JjolNavigation("match success")
}