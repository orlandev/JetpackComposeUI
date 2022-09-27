package com.orlandev.jetpackcomposeui.screens.dynamic

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orlandev.jetpackcomposeui.ui.theme.JetpackComposeUITheme
import com.orlandev.jetpackcomposeui.utils.CircularImageListBar
import kotlin.random.Random


@Composable
fun DynamicScreen() {

    val listOfItems = remember {
        derivedStateOf {
            generateImagesList()
        }
    }

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
                listOfUri = listOfItems.value,
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


//Generate Random Image Url List
fun generateImagesList(): List<String> {
    val listResult = mutableListOf<String>()
    val max = Random.nextInt(10, 100)

    repeat((0..max).count()) {
        val linkImage = "https://source.unsplash.com/random/${
            Random.nextInt(
                100, 200
            )
        }x${Random.nextInt(100, 200)}/?people"
        listResult.add(linkImage)
    }
    return listResult

}