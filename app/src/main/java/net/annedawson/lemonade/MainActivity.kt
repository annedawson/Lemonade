package net.annedawson.lemonade

/*
Date: Sunday 1st January 2023, 8:55 PT
Programmer: Anne Dawson
Email: anne.dawson@gmail.com
App: Lemonade
File: MainActivity.kt
Purpose: To demonstrate click behavior
From: https://developer.android.com/codelabs/basic-android-kotlin-compose-button-click-practice-problem
Status: Completed all but the part to click the second image a random number (2<= .. <=4) of times.
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.annedawson.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LabelAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LabelAndImage(modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf(1)
    }

    val myImageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val myTextResource = when (result) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon_squeeze
        3 -> R.string.lemon_drink
        else -> R.string.lemon_restart
    }
    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(myTextResource), fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(myImageResource), contentDescription = result.toString(),

            modifier = Modifier
                .size(200.dp, 280.dp)
                .border(2.dp, Color(105, 205, 216), RoundedCornerShape(3))
                .clip(RoundedCornerShape(16.dp))
                .padding(5.dp)
                .clickable(enabled = true, onClickLabel = "Clickable image", onClick = {
                    result++
                    if (result > 4) result = 1
                })
        )
    }
}