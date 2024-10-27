package pt.ipmaia.varias_janelas



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun Ecra01(
    tipoPessoa: MutableState<String>,
    nome: MutableState<String>,
    telefone: MutableState<String>,
    valor1: MutableState<String>,
    valor2: MutableState<String>,
    navController: NavHostController
) {
    var selectedOption by remember { mutableStateOf(valor1.value) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Escolha o tipo de pessoa:")

        Row {
            RadioButton(selected = selectedOption == valor1.value, onClick = { selectedOption = valor1.value })
            Text(valor1.value)
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = selectedOption == valor2.value, onClick = { selectedOption = valor2.value })
            Text(valor2.value)
        }

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = nome.value,
            onValueChange = { nome.value = it },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) { innerTextField ->
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                if (nome.value.isEmpty()) {
                    Text("Nome")
                }
                innerTextField()
            }
        }

        BasicTextField(
            value = telefone.value,
            onValueChange = { telefone.value = it },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) { innerTextField ->
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                if (telefone.value.isEmpty()) {
                    Text("Telefone")
                }
                innerTextField()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            tipoPessoa.value = selectedOption
            navController.navigate(Destino.Ecra02.route)
        }) {
            Text("Adicionar")
        }
    }
}


    @Composable
    fun Ecra02(
        tipoPessoa: MutableState<String>,
        nome: MutableState<String>,
        telefone: MutableState<String>
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Dados recebidos:", fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Tipo de pessoa: ${tipoPessoa.value}")
            Text("Nome: ${nome.value}")
            Text("Telefone: ${telefone.value}")
        }
    }


    @Composable
    fun Ecra03(valor1: MutableState<String>, valor2: MutableState<String>, navController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Escolha quais os tipos de pessoas:")

            Spacer(modifier = Modifier.height(16.dp))

            BasicTextField(
                value = valor1.value,
                onValueChange = { valor1.value = it },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) { innerTextField ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    if (valor1.value.isEmpty()) {
                        Text("Tipo 1: ")
                    }
                    innerTextField()
                }
            }

            BasicTextField(
                value = valor2.value,
                onValueChange = { valor2.value = it },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) { innerTextField ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    if (valor2.value.isEmpty()) {
                        Text("Tipo 2: ")
                    }
                    innerTextField()
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                navController.navigate(Destino.Ecra01.route)
            }) {
                Text("Adicionar")
            }

        }
    }


