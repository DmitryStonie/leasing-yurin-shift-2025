package com.dmitrystonie.leasingapp.ui

import com.dmitrystonie.leasingapp.account.ui.AccountRoute
import com.dmitrystonie.leasingapp.carlooking.ui.carlist.CarsRoute
import com.dmitrystonie.leasingapp.leasing.ui.orders.LeasingOrdersRoute
import kotlin.reflect.KClass

enum class NavigationOption(val route: KClass<*>) {
    CARS(CarsRoute::class),
    ORDERS(LeasingOrdersRoute::class),
    ACCOUNT(AccountRoute::class),
}