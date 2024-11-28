package tomoya.app.favorite_actor_app.component

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tomoya.app.favorite_actor_app.ActorData
import tomoya.app.favorite_actor_app.R
import tomoya.app.favorite_actor_app.demoActorData
import tomoya.app.favorite_actor_app.ui.theme.Favorite_actor_appTheme

@Composable
fun HomeRecommendListItem(
    data: ActorData,
    onClick: (ActorData)-> Unit,
    modifier: Modifier = Modifier
) {
   Card(
       modifier = modifier.clickable {
           onClick
       }
   ) {
       Box(){
           Image(painter = painterResource(R.drawable.actor2), contentScale = ContentScale.Fit, contentDescription = null)
           Box(modifier = modifier
               .fillMaxWidth()
               .align(Alignment.BottomCenter)
               .background(
                   color = colorResource(R.color.dark_effect)
               )
           ) {
                Column(modifier = modifier.padding(8.dp)) {
                    Row {
                        Text(data.name, color = colorResource(R.color.white), fontSize = 20.sp)
                        Spacer(modifier = modifier.width(10.dp))
                        Text("(${data.age})", color = colorResource(R.color.white))
                    }
                    Spacer(modifier = modifier.height(8.dp))
                    Text(data.category, color = colorResource(R.color.white))
                }
           }
       }
   }
}

@Preview
@Composable
private fun HomeRecommendListItemPreview() {
    Favorite_actor_appTheme {
        HomeRecommendListItem(demoActorData[0],{})
    }

}