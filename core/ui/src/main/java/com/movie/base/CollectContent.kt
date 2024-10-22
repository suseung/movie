package com.movie.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.movie.ext.toastS
import kotlinx.coroutines.launch

@Composable
fun CollectContent(
    viewModel: MVIViewModel<*, *, *>,
    processEffect: (ViewEffect) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(true) {
        launch {
            viewModel.effect.collect { processEffect(it) }
        }
        launch {
            viewModel.toastEffect.collect { context.toastS(it) }
        }
    }
}
