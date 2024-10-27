package pt.ipmaia.appteste1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.ipmaia.appteste1.ui.theme.AppTeste1Theme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.ipmaia.appteste1.ui.theme.Pink80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTeste1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    /*Text(
        text = "Hello $name!",
        modifier = modifier
    )*/

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()) {
    Button(onClick = {}, border = BorderStroke(1.dp, color = Pink80)) {
        Text(text = stringResource(id = R.string.textCalcular)) }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTeste1Theme {
        Greeting("Android")
    }
}