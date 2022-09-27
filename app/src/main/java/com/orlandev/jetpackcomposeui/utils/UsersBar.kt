package com.orlandev.jetpackcomposeui.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularImageListBar(
    modifier: Modifier,
    strokeColor: Color = Color.DarkGray,
    listOfUri: List<String>,
    onClick: () -> Unit
) {
    LazyRow(modifier = modifier) {

        items(listOfUri){ uri ->
            Card(
                modifier = Modifier
                    .size(85.dp)
                    .padding(8.dp)
                    .clickable {
                        onClick()
                    },
                elevation = 10.dp,
                border = BorderStroke(1.dp, color = strokeColor),
                shape = RoundedCornerShape(50)
            ) {
                ImageLoader(modifier = Modifier.fillMaxSize(), url = uri, loading = {
                    CircularProgressIndicator(color = Color.DarkGray)
                })
            }
        }
    }
}