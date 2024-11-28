package tomoya.app.favorite_actor_app.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tomoya.app.favorite_actor_app.R
import tomoya.app.favorite_actor_app.ui.theme.Favorite_actor_appTheme

@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)) {
        Image(
            painter = painterResource(R.drawable.actor2),
            contentScale = ContentScale.Crop,
            contentDescription = "header back"
        )
        Box(
            modifier = modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            colorResource(R.color.dark_effect),
                            colorResource(R.color.black)
                        )
                    )
                )
                .fillMaxSize()
        )
        Text(
            "What a Great day!",
            modifier = Modifier.align(Alignment.Center),
            fontSize = 24.sp,
            color = colorResource(R.color.white)
        )
    }
}

@Preview
@Composable
private fun HomeHeaderPreview() {
    Favorite_actor_appTheme {
        HomeHeader()
    }
}