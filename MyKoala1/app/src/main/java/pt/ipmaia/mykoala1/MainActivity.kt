package pt.ipmaia.mykoala1

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
import pt.ipmaia.mykoala1.ui.theme.MyKoala1Theme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyKoala1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InterfaceGrafico(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun InterfaceGrafico(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Nome: ", modifier = Modifier.weight(1f))
            CampoNome()
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Morada: ", modifier = Modifier.weight(1f))
            CampoMorada()
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Telefone: ", modifier = Modifier.weight(1f))
            CampoTelefone()
        }
    }
}

@Composable
fun CampoNome() {
    val valorDoNome = remember { mutableStateOf("") }
    TextField(
        value = valorDoNome.value,
        onValueChange = { valorDoNome.value = it },
        label = { Text("Digite seu nome") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CampoMorada() {
    val valorDaMorada = remember { mutableStateOf("") }
    TextField(
        value = valorDaMorada.value,
        onValueChange = { valorDaMorada.value = it },
        label = { Text("Digite sua morada") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CampoTelefone() {
    val valorDoTelefone = remember { mutableStateOf("") }
    TextField(
        value = valorDoTelefone.value,
        onValueChange = { valorDoTelefone.value = it },
        label = { Text("Digite seu telefone") },
        modifier = Modifier.fillMaxWidth()
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyKoala1Theme {
        InterfaceGrafico("Android")
    }
}