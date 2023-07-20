package com.br.commom.domain.interfaces

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.gson.Gson

abstract class ScreenDestination {

    abstract val icon: ImageVector
    abstract val route: String
    abstract val screen: @Composable (NavHostController, NavBackStackEntry) -> Unit

    val routeParamFormatted: String
        get() = "$route?$PARAM={$PARAM}"

    val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(PARAM) {
                type = NavType.StringType
                nullable = true
            }
        )

    fun <Param> getRouteForNavigationFormatted(param: Param): String {
        val json = Gson().toJson(param)
        return "$route?$PARAM=$json"
    }

    protected inline fun <reified Param> NavBackStackEntry.getParam(): Param? {
        return Gson().fromJson(arguments?.getString(PARAM), Param::class.java)
    }

    companion object {
        const val PARAM = "param"
    }

}