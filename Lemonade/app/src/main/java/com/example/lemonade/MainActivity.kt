package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {

        when (currentStep) {
            1 -> {
                LemonTextAndImage(
                    textId = R.string.lemon_select,
                    painterId = R.drawable.lemon_tree,
                    descriptionId = R.string.lemon_tree_content_description,
                    onStartClicked = {
                        currentStep = 2
                    }
                )
            }
            2 -> {
                LemonTextAndImage(
                    textId = R.string.lemon_squeeze,
                    painterId = R.drawable.lemon_squeeze,
                    descriptionId = R.string.lemonade_content_description,
                    onStartClicked = {
                        currentStep = 3
                    }
                )
            }
            3 -> {
                LemonTextAndImage(
                    textId = R.string.lemon_drink,
                    painterId = R.drawable.lemon_drink,
                    descriptionId = R.string.lemonade_content_description,
                    onStartClicked = {
                        currentStep = 4
                    }
                )
            }
            else -> {
                LemonTextAndImage(
                    textId = R.string.lemon_empty_glass,
                    painterId = R.drawable.lemon_restart,
                    descriptionId = R.string.empty_glass_content_description,
                    onStartClicked = {
                        currentStep = 1
                    }
                )
            }
        }
    }
}

@Composable
fun LemonTextAndImage(textId: Int, painterId: Int, descriptionId: Int, onStartClicked: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = stringResource(textId))
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(painterId),
            contentDescription = stringResource(descriptionId),
            modifier = Modifier
                .wrapContentSize()
                .clickable {
                    onStartClicked()
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}
