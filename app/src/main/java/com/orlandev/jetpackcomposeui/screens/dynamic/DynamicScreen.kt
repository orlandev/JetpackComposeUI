package com.orlandev.jetpackcomposeui.screens.dynamic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.orlandev.jetpackcomposeui.ui.theme.JetpackComposeUITheme


@Composable
fun DynamicScreen() {

    BoxWithConstraints(modifier = Modifier.background(Color.Red)) {

        

    }

}


@Preview(showBackground = true)
@Composable
fun PreviewDynamic() {

    JetpackComposeUITheme {
        DynamicScreen()
    }

}