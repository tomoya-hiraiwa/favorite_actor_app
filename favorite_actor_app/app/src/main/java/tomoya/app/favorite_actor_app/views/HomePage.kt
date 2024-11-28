package tomoya.app.favorite_actor_app.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import tomoya.app.favorite_actor_app.component.HomeHeader
import tomoya.app.favorite_actor_app.ui.theme.Favorite_actor_appTheme

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column(
             modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            HomeHeader(modifier)
            Text("Recommended Actors", fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
private fun HomePagePreview() {
    Favorite_actor_appTheme {
        HomePage()
    }
}



