package tomoya.app.favorite_actor_app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tomoya.app.favorite_actor_app.ui.theme.Favorite_actor_appTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Favorite_actor_appTheme {
                MyApp()
            }
        }
    }
}

//Base Composable
@Composable
fun MyApp() {
    //set navigation
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Top") {
        composable("Top") { TopPage(navController = navController) }
    }
}


//TopPage Composable
@Composable
fun TopPage(modifier: Modifier = Modifier, navController: NavHostController) {
    //show authDialog flag
    var showBiometricDialog by remember { mutableStateOf(false) }
    //auth result text
    var biometricResult by remember { mutableStateOf<String?>(null) }

    //show authDialog when flag is true
    if (showBiometricDialog) {
        BiometricAuthenticationDialog(
            //callback if auth is successful
            onAuthSuccess = { biometricResult = "Success" },
            //callback if auth is failed or error
            onAuthError = { error ->
                biometricResult = error
                showBiometricDialog = false
            }
        )
    }

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(R.drawable.actor),
            contentDescription = "background",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.dark_effect))
        )
        Text(
            "Memory your favorite Actor",
            style = TextStyle(color = colorResource(R.color.white), fontSize = 30.sp),
            modifier = Modifier.align(
                Alignment.Center
            )
        )
        Button(
            onClick = { showBiometricDialog = true }, modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 200.dp)
        ) {
            Text("Authorization and Start")
        }

    }
}

//AuthDialog Composable
@Composable
fun BiometricAuthenticationDialog(
    onAuthSuccess: () -> Unit,
    onAuthError: (String) -> Unit
) {
    //get context
    val context = LocalContext.current
    //get Executor(executor manages threads and tasks)
    val executor = ContextCompat.getMainExecutor(context)

    //create auth prompt using remember(because we don't need recreate this)
    val biometricPrompt = remember {
        BiometricPrompt(
            context as FragmentActivity,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {
                //if auth is successful.
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    onAuthSuccess()
                }
                //if auth is error.
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    onAuthError(errString.toString())
                }
                //if auth is failed.
                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    onAuthError("Authentication failed.")
                }
            }
        )
    }

    //set authDialog text and launch dialog
    LaunchedEffect(Unit) {
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Authentication")
            .setSubtitle("Please touch your finger")
            .setNegativeButtonText("Cancel")
            .build()
        biometricPrompt.authenticate(promptInfo)
    }
}
