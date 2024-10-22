package com.movie.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.movie.designsystem.ThemePreview
import com.movie.designsystem.theme.MovieTheme

@Composable
fun NetworkErrorScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "현재 서버와의 연결이 불안정합니다. \n 다시 시도하거나 네트워크 설정을 확인해주세요.",
            style = MovieTheme.typos.bold.font16,
            color = MovieTheme.colors.label.onBgPrimary,
            modifier = Modifier.padding(bottom = 20.dp),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = onClick,
            modifier = Modifier.background(
                color = MovieTheme.colors.system.yellow,
                shape = RoundedCornerShape(20.dp)
            ),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = MovieTheme.colors.system.yellow
            )
        ) {
            Text(
                text = "다시 시도",
                style = MovieTheme.typos.bold.font16,
                color = MovieTheme.colors.background.defaultBase
            )
        }
    }
}

@ThemePreview
@Composable
fun NetworkErrorScreenPreview() {
    MovieTheme {
        NetworkErrorScreen()
    }
}
