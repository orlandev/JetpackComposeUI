package com.orlandev.jetpackcomposeui.utils

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun ImageLoader(modifier: Modifier, url: String) {

    val model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build()

    SubcomposeAsyncImage(
        modifier = modifier, model = model, contentScale = ContentScale.Crop, loading = {
            CircularProgressIndicator()
        }, contentDescription = null
    )
}