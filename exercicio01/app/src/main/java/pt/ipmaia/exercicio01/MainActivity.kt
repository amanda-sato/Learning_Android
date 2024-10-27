package pt.ipmaia.exercicio01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import pt.ipmaia.exercicio01.ui.theme.Exercicio01Theme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exercicio01Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PontuacaoQuadro()
                }
            }
        }
    }
}

@Composable
fun PontuacaoQuadro() {
    var pontosIniciais by remember { mutableStateOf("") }
    var tipoSelecionado by remember { mutableStateOf("Evento") }

    var qntEventos by remember { mutableStateOf(0) }
    var qntArtigos by remember { mutableStateOf(0) }
    var qntProjetos by remember { mutableStateOf(0) }
    var totalPontos by remember { mutableStateOf(0) }

    val adicionarPontos = {
        val pontosBase = pontosIniciais.toIntOrNull() ?: 0
        when (tipoSelecionado) {
            "Evento" -> {
                qntEventos++
                totalPontos += 10 + pontosBase
            }
            "Artigo" -> {
                qntArtigos++
                totalPontos += 30 + pontosBase
            }
            "Projeto" -> {
                qntProjetos++
                totalPontos += 20 + pontosBase
            }

        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = pontosIniciais,
            onValueChange = { pontosIniciais = it },
            label = { Text("Pontuação Inicial") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            singleLine = true
        )

        Column {
            Text("Escolha o Tipo:")
            RadioButtonGroup(
                options = listOf("Evento", "Artigo", "Projeto"),
                selectedOption = tipoSelecionado,
                onOptionSelected = { tipoSelecionado = it }
            )
        }


        Button(
            onClick = adicionarPontos,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Adicionar")
        }


        Spacer(modifier = Modifier.height(16.dp))
        Text("Qnt Eventos: $qntEventos")
        Text("Qnt Artigos: $qntArtigos")
        Text("Qnt Projetos: $qntProjetos")
        Text("Total de Pontos: $totalPontos")
    }
}

@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { onOptionSelected(option) }
                )
                Text(option, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPontuacaoQuadro() {
    Exercicio01Theme {
        PontuacaoQuadro()
    }
}
