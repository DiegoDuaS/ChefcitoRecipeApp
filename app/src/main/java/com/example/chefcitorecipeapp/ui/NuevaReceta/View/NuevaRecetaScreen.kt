package com.example.chefcitorecipeapp.ui.NuevaReceta.View

import android.annotation.SuppressLint
import android.widget.CheckBox
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.navigation.Screen
import com.example.chefcitorecipeapp.ui.Despensa.View.DespensaScreen
import com.example.chefcitorecipeapp.ui.Despensa.View.IngredientesParaPreview
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo

data class IngredientesParaPreview(
    val name:String,
    val cantidad: Int,
    val tipo: String
)

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewRecipeScreen(navController: NavController){

    var name by remember { mutableStateOf(TextFieldValue("")) }
    var time by remember { mutableStateOf(TextFieldValue("")) }
    var pasonuevo by remember { mutableStateOf(TextFieldValue("")) }
    var pasos = mutableStateListOf<String>()

    val ingredientes = listOf(
        IngredientesParaPreview("Ingrediente 1", 3, "Unidad"),
        IngredientesParaPreview("Ingrediente 2", 10, "Gramos"),
        IngredientesParaPreview("Ingrediente 3", 7, "Litro"),
        IngredientesParaPreview("Ingrediente 4", 12, "Unidad"),
        IngredientesParaPreview("Ingrediente 5", 1, "Gramos"),
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Fondo)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Fondo),
            contentAlignment = Alignment.TopCenter
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Fondo),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(color = ColorMain),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        ElevatedButton(
                            onClick = {
                                navController.navigateUp()
                            },
                            shape = CircleShape
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ArrowBack,
                                contentDescription = null
                            )
                        }
                        Text(
                            text = stringResource(id = R.string.nuevareceta),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .padding(vertical = 0.dp)
                                .padding(horizontal = 4.dp),
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )

                    }
                }
                    LazyColumn{
                        item{
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Fondo),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                OutlinedTextField(
                                    value = name,
                                    onValueChange = { name = it },
                                    textStyle = MaterialTheme.typography.bodySmall,
                                    label = {
                                        Text(
                                            text = stringResource(id = R.string.nombre_receta),
                                            style = MaterialTheme.typography.bodySmall,
                                            modifier = Modifier
                                                .padding(vertical = 0.dp)
                                                .padding(horizontal = 4.dp),
                                            textAlign = TextAlign.Center,
                                            color = Color.Black
                                        )
                                    },
                                    singleLine = true,
                                    modifier = Modifier
                                        .height(60.dp)
                                )
                                OutlinedTextField(
                                    value = time,
                                    onValueChange = { time = it },
                                    textStyle = MaterialTheme.typography.bodySmall,
                                    label = {
                                        Text(
                                            text = stringResource(id = R.string.tiempo_preparacion_ask),
                                            style = MaterialTheme.typography.bodySmall,
                                            modifier = Modifier
                                                .padding(vertical = 0.dp)
                                                .padding(horizontal = 4.dp),
                                            textAlign = TextAlign.Center,
                                            color = Color.Black
                                        )
                                    },
                                    singleLine = true,
                                    modifier = Modifier
                                        .height(60.dp),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                                )
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .background(color = Fondo),
                                    colors = CardDefaults.cardColors(
                                        containerColor = ColorMain,
                                    ),
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(color = ColorMain),
                                        horizontalAlignment = Alignment.CenterHorizontally,

                                    ) {
                                        Row(

                                        ) {
                                            Text(
                                                text = stringResource(id = R.string.ingredientes_titulo_newr),
                                                style = MaterialTheme.typography.bodyMedium,
                                                modifier = Modifier
                                                    .padding(vertical = 0.dp)
                                                    .padding(horizontal = 4.dp),
                                                textAlign = TextAlign.Center,
                                                color = Color.White
                                            )
                                        }
                                        CheckBoxes(ingredientes = ingredientes)
                                    }
                                }
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .background(color = Fondo),
                                    colors = CardDefaults.cardColors(
                                        containerColor = ColorMain,
                                    ),
                                ){
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(color = ColorMain),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ){
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = stringResource(id = R.string.pasos_titulo_newr),
                                            style = MaterialTheme.typography.bodyMedium,
                                            modifier = Modifier
                                                .padding(vertical = 0.dp)
                                                .padding(horizontal = 4.dp),
                                            textAlign = TextAlign.Center,
                                            color = Color.White
                                        )
                                        Spacer(modifier = Modifier.width(30.dp))
                                        if (pasos.isEmpty()){
                                            Text(
                                                text = stringResource(id = R.string.no_pasos_message),
                                                style = MaterialTheme.typography.bodySmall,
                                                modifier = Modifier
                                                    .padding(vertical = 0.dp)
                                                    .padding(horizontal = 4.dp),
                                                textAlign = TextAlign.Center,
                                                color = Color.White
                                            )
                                            Spacer(modifier = Modifier.width(10.dp))
                                        }
                                        else{
                                            pasos.forEachIndexed{ index: Int, paso: String ->
                                                val num = index + 1
                                                Row(

                                                ){
                                                    Spacer(modifier = Modifier.width(8.dp))
                                                    Text(
                                                        text = "$num. $paso",
                                                        style = MaterialTheme.typography.bodySmall,
                                                        modifier = Modifier
                                                            .padding(vertical = 0.dp)
                                                            .padding(horizontal = 4.dp),
                                                        textAlign = TextAlign.Center,
                                                        color = Color.White
                                                    )
                                                    Spacer(modifier = Modifier.width(8.dp))
                                                }

                                            }
                                        }
                                    }
                                }
                                OutlinedTextField(
                                    value = pasonuevo,
                                    onValueChange = { pasonuevo = it },
                                    textStyle = MaterialTheme.typography.bodySmall,
                                    label = {
                                        Text(
                                            text = stringResource(id = R.string.paso_nuevo),
                                            style = MaterialTheme.typography.bodySmall,
                                            modifier = Modifier
                                                .padding(vertical = 0.dp)
                                                .padding(horizontal = 4.dp),
                                            textAlign = TextAlign.Center,
                                            color = Color.Black
                                        )
                                    },
                                    singleLine = true,
                                    modifier = Modifier
                                        .height(60.dp)
                                )
                                Button(
                                    onClick = {
                                        if(pasonuevo == null){

                                        }
                                        else{
                                            pasos.add(pasonuevo.text)
                                            pasonuevo = TextFieldValue("")
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = ColorMain)

                                ) {
                                    Text(
                                        text = stringResource(id = R.string.add_paso),
                                        style = MaterialTheme.typography.bodySmall,
                                        modifier = Modifier
                                            .padding(vertical = 0.dp)
                                            .padding(horizontal = 4.dp),
                                        textAlign = TextAlign.Center,
                                        color = Color.White)
                                }
                                Card(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .background(color = Fondo)
                                        .width(300.dp)
                                        .height(300.dp)
                                        .clickable {
                                            //Agregar Imagen
                                        },
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.LightGray,
                                    ),
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(color = Color.LightGray),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Spacer(modifier = Modifier.height(130.dp))
                                        Text(
                                            text = stringResource(id = R.string.agregar_imagen),
                                            style = MaterialTheme.typography.bodyMedium,
                                            modifier = Modifier
                                                .padding(vertical = 0.dp)
                                                .padding(horizontal = 4.dp),
                                            textAlign = TextAlign.Center,
                                            color = Color.Black
                                        )
                                    }
                                }
                                Button(
                                    onClick = {
                                        navController.navigateUp()
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = ColorMain)

                                ) {
                                    Text(
                                        text = stringResource(id = R.string.agregar_receta),
                                        style = MaterialTheme.typography.bodySmall,
                                        modifier = Modifier
                                            .padding(vertical = 0.dp)
                                            .padding(horizontal = 4.dp),
                                        textAlign = TextAlign.Center,
                                        color = Color.White)
                                }

                            }

                        }
                    }

            }
        }
    }
}

data class ToggableInfo(
    val isChecked:Boolean,
    val text: String
)

@Composable
private fun CheckBoxes(ingredientes: List<IngredientesParaPreview>){

    val checkedIngredients = remember { mutableStateListOf<IngredientesParaPreview>() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ColorMain),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ingredientes.forEach { ingrediente ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Checkbox(checked = checkedIngredients.contains(ingrediente),
                        onCheckedChange = { isChecked ->
                            if (isChecked) {
                                checkedIngredients.add(ingrediente)
                            } else {
                                checkedIngredients.remove(ingrediente)
                            }
                        })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = ingrediente.name,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(vertical = 0.dp)
                            .padding(horizontal = 4.dp),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewRecipeScreenPreview() {
    ChefcitoRecipeAppTheme {
        val navController = rememberNavController()
        NewRecipeScreen(navController = navController)
    }
}