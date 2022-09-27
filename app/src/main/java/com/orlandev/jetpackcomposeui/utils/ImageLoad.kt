package com.orlandev.jetpackcomposeui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun ImageLoader(modifier: Modifier, url: String, loading: @Composable () -> Unit) {

    val model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build()

    SubcomposeAsyncImage(
        modifier = modifier, model = model, contentScale = ContentScale.Crop,
        loading = {
            loading()
        }, contentDescription = null
    )
}