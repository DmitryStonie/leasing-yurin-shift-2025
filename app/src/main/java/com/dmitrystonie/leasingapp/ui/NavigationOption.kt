package com.dmitrystonie.leasingapp.ui

import com.dmitrystonie.leasingapp.account.ui.AccountRoute
import com.dmitrystonie.leasingapp.carlooking.ui.carlist.CarsRoute
import com.dmitrystonie.leasingapp.leasing.ui.OrdersRoute
import kotlin.reflect.KClass

enum class NavigationOption(val route: KClass<*>) {
    CARS(CarsRoute::class),
    ORDERS(OrdersRoute::class),
    ACCOUNT(AccountRoute::class),
}