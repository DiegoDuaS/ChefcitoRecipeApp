package com.example.chefcitorecipeapp.ui.NuevaReceta.View

import android.widget.Toast
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.ui.NuevaReceta.Model.NuevaRecetaViewModel
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo
import java.util.UUID

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewRecipeScreen(navController: NavController,
                    viewModel: NuevaRecetaViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

){

    var name by remember { mutableStateOf(TextFieldValue("")) }
    var time by remember { mutableStateOf(TextFieldValue("")) }
    var pasonuevo by remember { mutableStateOf(TextFieldValue("")) }
    var showDialog by remember { mutableStateOf(false) }
    var imageUrl by remember { mutableStateOf("") }



    var pasos = mutableStateListOf<String>()
    val context = LocalContext.current
    val context_two = LocalContext.current

    val ingredientes = listOf(
        IngredientesParaPreview("Pollo", 3, "Unidad"),
        IngredientesParaPreview("Carne_Molida", 10, "Gramos"),
        IngredientesParaPreview("Pasta", 7, "Litro"),
        IngredientesParaPreview("Arroz", 12, "Unidad"),
        IngredientesParaPreview("Harina", 1, "Gramos"),
        IngredientesParaPreview("Papa", 1, "Gramos"),
        IngredientesParaPreview("Cebolla", 3, "Unidad"),
        IngredientesParaPreview("Ajo", 3, "Unidad"),
        IngredientesParaPreview("Sal", 3, "Unidad"),
        IngredientesParaPreview("Pimienta", 3, "Unidad"),
        IngredientesParaPreview("Huevos", 3, "Unidad"),
        IngredientesParaPreview("Leche", 3, "Unidad"),
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
                                        CheckBoxes(ingredientes = ingredientes){updatedList ->
                                            viewModel.saveIngredientsState(updatedList)

                                        }
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
                                        if(pasonuevo == null || pasonuevo == TextFieldValue("")){
                                            Toast.makeText(context,R.string.notenughstep, Toast.LENGTH_LONG).show()
                                        }
                                        else if(pasonuevo != null && pasonuevo != TextFieldValue("")){
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
                                        .clickable {showDialog = true},
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.LightGray,
                                    ),
                                ) {

                                    //Aqui esta el codigo feo
                                    if (showDialog) {
                                        Dialog(onDismissRequest = { showDialog = false }) {
                                            Surface {
                                                Column(modifier = Modifier.padding(16.dp)) {
                                                    Text(text = "Enter Image URL")
                                                    TextField(
                                                        value = imageUrl,
                                                        onValueChange = { imageUrl = it },
                                                        label = { Text("URL") },
                                                        singleLine = true,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(4.dp)
                                                    )
                                                    Button(onClick = {
                                                        showDialog = false
                                                    }) {
                                                        Text("Submit")
                                                    }
                                                }
                                            }
                                        }
                                    }

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
                                        if (imageUrl.isEmpty()) {
                                            Toast.makeText(context, "Image URL must not be empty.", Toast.LENGTH_LONG).show()
                                        } else if (pasos.isEmpty() || name.text.isEmpty() || time.text.isEmpty()) {
                                            Toast.makeText(context_two, R.string.notenoughpara, Toast.LENGTH_LONG).show()
                                        } else {
                                            val postId = TextFieldValue(UUID.randomUUID().toString())
                                            viewModel.addRecipeToFirestore(
                                                name = name,
                                                postId = postId,
                                                preparationTime = time,
                                                checkedIngredients = viewModel.ingredientsState,
                                                pasos = pasos,
                                                imageUrl = imageUrl
                                            )
                                            navController.navigateUp()
                                        }
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





data class IngredientesParaPreview(
    val name:String,
    val cantidad: Int,
    val tipo: String
)

@Composable
private fun CheckBoxes(ingredientes: List<IngredientesParaPreview>,
                       onCheckedChange: (List<IngredientesParaPreview>) -> Unit

){

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
                    Checkbox(
                        checked = checkedIngredients.contains(ingrediente),
                        onCheckedChange = { isChecked ->
                            if (isChecked) {
                                checkedIngredients.add(ingrediente)
                            } else {
                                checkedIngredients.remove(ingrediente)
                            }
                            onCheckedChange(checkedIngredients)
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