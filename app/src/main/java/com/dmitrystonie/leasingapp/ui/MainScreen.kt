package com.dmitrystonie.leasingapp.ui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.dmitrystonie.leasingapp.account.ui.AccountRoute
import com.dmitrystonie.leasingapp.account.ui.AccountScreen
import com.dmitrystonie.leasingapp.carlooking.ui.car.CarCardRoute
import com.dmitrystonie.leasingapp.carlooking.ui.filters.CarFiltersRoute
import com.dmitrystonie.leasingapp.carlooking.ui.car.CarScreen
import com.dmitrystonie.leasingapp.carlooking.ui.carlist.CarsListScreen
import com.dmitrystonie.leasingapp.carlooking.ui.carlist.CarsRoute
import com.dmitrystonie.leasingapp.component.ui.CarsBottomAppBar
import com.dmitrystonie.leasingapp.leasing.ui.OrdersRoute
import com.dmitrystonie.leasingapp.leasing.ui.OrdersScreen
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val selectedTab = rememberSaveable { mutableStateOf(NavigationOption.CARS) }

    LaunchedEffect(key1 = Unit) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val openedOption =
                NavigationOption.entries.firstOrNull { destination.hasRoute(it.route) }

            if (openedOption != null) {
                selectedTab.value = openedOption
            }
        }
    }

    Scaffold(containerColor = BgPrimary) { paddingValues: PaddingValues ->
        Column(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = CarsRoute,
            ) {
                animatedComposable<CarsRoute> {
                    CarsListScreen(
                        onCarClick = { carId ->
                            navController.navigate(CarCardRoute(carId))
                        },
                        onFiltersClick = { navController.navigate(CarFiltersRoute) },
                    )
                }
                animatedComposable<OrdersRoute> {
                    OrdersScreen()
                }
                animatedComposable<AccountRoute> {
                    AccountScreen()
                }
                animatedComposable<CarCardRoute> {
                    val destination = it.toRoute<CarCardRoute>()

                    CarScreen(
                        onBackClick = { navController.navigateUp() },
                        carId = destination.carId
                    )
                }
            }
            CarsBottomAppBar(
                navigationOptions = NavigationOption.entries,
                selectedNavigationOption = selectedTab.value,
                onItemClicked = { navOption ->
                    when (navOption) {

                        NavigationOption.CARS -> navController.openPoppingAllPrevious(CarsRoute)
                        NavigationOption.ORDERS -> navController.openPoppingAllPrevious(OrdersRoute)
                        NavigationOption.ACCOUNT -> navController.openPoppingAllPrevious(AccountRoute)
                    }

                    selectedTab.value = navOption
                }
            )
        }
    }
}

inline fun <reified T : Any> NavGraphBuilder.animatedComposable(noinline block: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit) {
    composable<T>(
        enterTransition = ENTER_TRANSITION,
        exitTransition = EXIT_TRANSITION,
        popEnterTransition = POP_ENTER_TRANSITION,
        popExitTransition = POP_EXIT_TRANSITION,
        content = block
    )
}

fun NavController.openPoppingAllPrevious(route: Any) {
    this.navigate(route) {
        popUpTo(graph.startDestinationId)
        launchSingleTop = true
    }
}