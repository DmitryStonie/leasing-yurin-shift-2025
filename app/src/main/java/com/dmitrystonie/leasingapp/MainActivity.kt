package com.dmitrystonie.leasingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dmitrystonie.leasingapp.carlooking.ui.CarsTopAppBar
import com.dmitrystonie.leasingapp.carlooking.ui.CarsTopAppBarWithLeftIcon
import com.dmitrystonie.leasingapp.carlooking.ui.CarsTopAppBarWithRightIcon
import com.dmitrystonie.leasingapp.carlooking.ui.CarsTopAppBarWithoutIcons
import com.dmitrystonie.leasingapp.ui.theme.IndicatorNormal
import com.dmitrystonie.leasingapp.ui.theme.LeasingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeasingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarsTopAppBar(
                        text = stringResource(R.string.cars_top_app_bar_title),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeasingAppTheme {
        CarsTopAppBarWithoutIcons(
            text = stringResource(R.string.cars_top_app_bar_title),
        )
    }
}