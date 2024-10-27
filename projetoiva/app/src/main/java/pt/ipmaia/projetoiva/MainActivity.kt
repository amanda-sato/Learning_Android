package pt.ipmaia.projetoiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.ipmaia.projetoiva.ui.theme.ProjetoivaTheme
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetoivaTheme {
                Surface() { ConverterIva() }
            }
        }
    }
}

@Composable
fun ConverterIva() {
    val campoValor = remember { mutableStateOf("") }
    val campoIva = remember { mutableStateOf("") }
    val resultado = remember { mutableStateOf("") }
    val totalAcumulado = remember { mutableStateOf(0f) }

    val calcular = {
        val valor = campoValor.value.toFloatOrNull() ?: 0f
        val iva = campoIva.value.toFloatOrNull() ?: 0f
        val total = valor + (valor * (iva / 100))
        totalAcumulado.value += total
        resultado.value = total.toString()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = campoValor.value,
                onValueChange = { campoValor.value = it },
                label = { Text(text = "Valor") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .weight(1f)
            )

            TextField(
                value = campoIva.value,
                onValueChange = { campoIva.value = it },
                label = { Text(text = "IVA (%)") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .weight(1f)
            )
        }

        Button(onClick = calcular, modifier = Modifier.padding(bottom = 16.dp)) {
            Text(text = "Adicionar")
        }

        if (resultado.value.isNotEmpty()) {
            Text(text = "Subtotal: ${resultado.value}", style = MaterialTheme.typography.headlineMedium)
        }

        if (totalAcumulado.value > 0f) {
            Text(text = "Total Acumulado: ${totalAcumulado.value}", style = MaterialTheme.typography.headlineMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConverterIva() {
    ProjetoivaTheme {
        ConverterIva()
    }
}
