package com.orlandev.jetpackcomposeui.screens.dynamic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orlandev.jetpackcomposeui.R
import com.orlandev.jetpackcomposeui.ui.theme.JetpackComposeUITheme
import com.orlandev.jetpackcomposeui.utils.CircularImageListBar
import com.orlandev.jetpackcomposeui.utils.ImageLoader
import kotlin.random.Random


@Composable
fun DynamicScreen() {

    val listOfPeoples = remember {
        derivedStateOf {
            generateImagesList("people")
        }
    }


    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
           item {
               JCTopBar(
                   modifier = Modifier.fillMaxWidth(),
                   title = stringResource(id = com.orlandev.jetpackcomposeui.R.string.dynamic_screen_name)
               )
           }

            item {
                CircularImageListBar(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                    listOfUri = listOfPeoples.value,
                    onClick = {})
            }

            item {
                PlacesSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    title = stringResource(id = R.string.recomended)
                )
            }

            item {
                PlacesSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    title = stringResource(id = R.string.my_cars),
                    "cars"
                )
            }

            item {
                PlacesSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    title = stringResource(id = R.string.my_phones),
                    "phone"
                )
            }

            item {
                PlacesSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    title = stringResource(id = R.string.my_trucks),
                    "trucks"
                )
            }
        }
    }
}

@Composable
fun PlacesSection(modifier: Modifier, title: String, theme: String = "places") {

    val listOfPlaces = remember {
        derivedStateOf {
            generateImagesList(theme)
        }
    }


    Column(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = title,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Spacer(modifier = Modifier.width(10.dp))
            }
            items(listOfPlaces.value) {
                PlaceUI(it)
            }
            item {
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }

}

@Composable
fun PlaceUI(url: String) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(130.dp), shape = RoundedCornerShape(20)
    ) {
        ImageLoader(modifier = Modifier.fillMaxSize(), url = url) {

        }
    }
}


@Composable
fun JCTopBar(modifier: Modifier, title: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Row(modifier = modifier, horizontalArrangement = Arrangement.Start) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Menu, contentDescription = null)
            }
        }
        Text(
            modifier = Modifier.padding(start = 12.dp),
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
fun generateImagesList(theme: String): List<String> {
    val listResult = mutableListOf<String>()
    val max = Random.nextInt(10, 100)

    repeat((0..max).count()) {
        val linkImage = generateImageUrl(theme)
        listResult.add(linkImage)
    }
    return listResult

}

fun generateImageUrl(theme: String): String = "https://source.unsplash.com/random/${
    Random.nextInt(
        100, 200
    )
}x${Random.nextInt(100, 200)}/?$theme"

