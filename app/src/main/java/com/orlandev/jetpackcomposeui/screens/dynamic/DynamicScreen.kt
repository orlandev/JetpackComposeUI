package com.orlandev.jetpackcomposeui.screens.dynamic

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.orlandev.jetpackcomposeui.ui.theme.JetpackComposeUITheme
import com.orlandev.jetpackcomposeui.utils.ImageLoader


@Composable
fun DynamicScreen() {

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {

        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Top) {
            JCTopBar(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = com.orlandev.jetpackcomposeui.R.string.dynamic_screen_name)
            )

            UsersBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

        }
    }
}


@Composable
fun UsersBar(modifier: Modifier, max: Int = 10) {

    val listOfPeoples = "https://source.unsplash.com/random/?people"

    val scrollState = rememberScrollState()

    Row(modifier = modifier.horizontalScroll(scrollState)) {

        repeat((0..max).count()) {
            Card(
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                elevation = 8.dp,
                shape = RoundedCornerShape(50)
            ) {
                ImageLoader(modifier = Modifier.fillMaxSize(), url = listOfPeoples)
            }
        }
    }
}

@Composable
fun JCTopBar(modifier: Modifier, title: String) {
    Column(modifier = Modifier) {
        Row(modifier = modifier, horizontalArrangement = Arrangement.Start) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Menu, contentDescription = null)
            }
        }
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewDynamic() {

    JetpackComposeUITheme {
        DynamicScreen()
    }

}