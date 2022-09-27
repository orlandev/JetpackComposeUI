package com.orlandev.jetpackcomposeui.screens.dynamic

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orlandev.jetpackcomposeui.ui.theme.JetpackComposeUITheme
import com.orlandev.jetpackcomposeui.utils.CircularImageListBar


@Composable
fun DynamicScreen() {

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Top) {
            JCTopBar(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = com.orlandev.jetpackcomposeui.R.string.dynamic_screen_name)
            )

            CircularImageListBar(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                listOfUri = listOf(
                    "https://source.unsplash.com/random/?people",
                    "https://source.unsplash.com/random/?people",
                    "https://source.unsplash.com/random/?people",
                    "https://source.unsplash.com/random/?people",
                    "https://source.unsplash.com/random/?people",
                    "https://source.unsplash.com/random/?people",
                    "https://source.unsplash.com/random/?people",
                    "https://source.unsplash.com/random/?people",
                    "https://source.unsplash.com/random/?people",
                ),
                onClick = {})
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