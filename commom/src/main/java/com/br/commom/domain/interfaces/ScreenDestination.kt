package com.br.commom.domain.interfaces

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.gson.Gson

abstract class ScreenDestination {

    abstract val screen: @Composable (NavHostController, NavBackStackEntry) -> Unit
    abstract val icon: ImageVector
    abstract val route: String

    private var paramJson: String? = null

    val routePath: String get() = "$route?$PARAM={$PARAM}"
    val routePathNavigation: String get() = "$route?$PARAM=$paramJson"
    val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(PARAM) {
                defaultValue = paramJson
                type = NavType.StringType
                nullable = true
            }
        )

    fun <Param> setParam(param: Param?): ScreenDestination = apply {
        paramJson = Gson().toJson(param)
    }

    protected inline fun <reified Param> NavBackStackEntry.getParam(): Param =
        Gson().fromJson(arguments?.getString(PARAM), Param::class.java)
            ?: throw IllegalArgumentException("The parameter for the route was not defined")

    companion object {
        const val PARAM = "param"
    }
}