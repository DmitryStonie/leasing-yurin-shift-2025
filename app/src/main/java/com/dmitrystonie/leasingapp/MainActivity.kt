package com.dmitrystonie.leasingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.component.ui.ColouredButtonWithIcon
import com.dmitrystonie.leasingapp.ui.MainScreen
import com.dmitrystonie.leasingapp.ui.theme.BgDisable
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.BorderLight
import com.dmitrystonie.leasingapp.ui.theme.LeasingAppTheme
import com.dmitrystonie.leasingapp.ui.theme.TextBrandDisabled
import com.dmitrystonie.leasingapp.ui.theme.TextSecondary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeasingAppTheme {
                MainScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeasingAppTheme {
        ColouredButtonWithIcon(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            buttonColors = ButtonDefaults.buttonColors(
                contentColor = TextSecondary,
                containerColor = BgPrimary,
                disabledContainerColor = BgDisable,
                disabledContentColor = TextBrandDisabled,
            ),
            text = "Войти",
            painterResource(R.drawable.sliders),
            iconContentDescription = "Открыть даты",
            border = BorderStroke(1.dp, BorderLight)
        )
    }
}