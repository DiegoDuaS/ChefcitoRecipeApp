package com.example.chefcitorecipeapp.ui.Despensa.View

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.ui.Despensa.Model.DespensaVIewModel
import com.example.chefcitorecipeapp.ui.FirebaseData.MySingleton
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext


data class IngredientesParaPreview(
    val name:String,
    val cantidad: Int,
    val tipo: String
)

@Composable
fun DespensaScreen(navController: NavController,
                   viewModel: DespensaVIewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){




    //Lista provicional
    val ingredientes = listOf(
        IngredientesParaPreview("Pollo", 3, "Unidad"),
        IngredientesParaPreview("Carne Molida", 10, "Gramos"),
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Fondo),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
                            shape = CircleShape,
                            onClick = {
                                navController.navigateUp()
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ArrowBack,
                                contentDescription = null
                            )
                        }
                        Text(
                            text = stringResource(id = R.string.despensa),
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
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                    item{
                        CheckBoxes(ingredientes = ingredientes, viewModel = viewModel)
                    }
                    item{
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Fondo),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            val context = LocalContext.current
                            Button(
                                onClick = {
                                    Toast.makeText(context, R.string.datasavedsucc, Toast.LENGTH_SHORT).show()
                                    viewModel.updateFirestoreDocument()
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = ColorMain)
                            ){
                                Text(
                                    text = stringResource(id = R.string.savechanges),
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
        }
    }
}

@Composable
private fun CheckBoxes(ingredientes: List<IngredientesParaPreview>,viewModel: DespensaVIewModel){

    val checkedIngredients = remember { mutableStateListOf<IngredientesParaPreview>() }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ingredientes.forEach { ingrediente ->
            val IsChecked = when(ingrediente.name) {
                "Pollo" -> viewModel.polloState.observeAsState(MySingleton.Pollo).value ?: false
                "Carne Molida" -> viewModel.MolidaState.observeAsState(MySingleton.Carne_Molida).value ?: false
                "Pasta" -> viewModel.PastaState.observeAsState(MySingleton.Pasta).value ?: false
                "Arroz" -> viewModel.ArrozState.observeAsState(MySingleton.Arroz).value ?: false
                "Harina" -> viewModel.HarinaState.observeAsState(MySingleton.Harina).value ?: false
                "Papa" -> viewModel.PapaState.observeAsState(MySingleton.Papa).value ?: false
                "Cebolla" -> viewModel.CebollaState.observeAsState(MySingleton.Cebolla).value ?: false
                "Ajo" -> viewModel.AjoState.observeAsState(MySingleton.Ajo).value ?: false
                "Sal" -> viewModel.SalState.observeAsState(MySingleton.Sal).value ?: false
                "Pimienta" -> viewModel.PimientaState.observeAsState(MySingleton.Pimienta).value ?: false
                "Huevos" -> viewModel.HuevosState.observeAsState(MySingleton.Huevos).value ?: false
                "Leche" -> viewModel.LecheState.observeAsState(MySingleton.Leche).value ?: false
                else -> false
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(color = Fondo)
                    .height(80.dp),
                colors = CardDefaults.cardColors(
                    containerColor = ColorMain,
                ),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Checkbox(
                            checked = IsChecked,
                            onCheckedChange = { checked ->
                                when (ingrediente.name) {
                                    "Pollo" -> viewModel.updatePollo(checked)
                                    "Carne Molida" -> viewModel.updateCarneMolida(checked)
                                    "Pasta" -> viewModel.updatePasta(checked)
                                    "Arroz" -> viewModel.updateArroz(checked)
                                    "Harina" -> viewModel.updateHarina(checked)
                                    "Papa" -> viewModel.updatePapa(checked)
                                    "Cebolla" -> viewModel.updateCebolla(checked)
                                    "Ajo" -> viewModel.updateAjo(checked)
                                    "Sal" -> viewModel.updateSal(checked)
                                    "Pimienta" -> viewModel.updatePimienta(checked)
                                    "Huevos" -> viewModel.updateHuevos(checked)
                                    "Leche" -> viewModel.updateLeche(checked)
                                }
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = ingrediente.name,
                            style = MaterialTheme.typography.bodyMedium,
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
}

@Preview(showBackground = true)
@Composable
fun DespensaScreenPreview() {
    ChefcitoRecipeAppTheme {
        val navController = rememberNavController()
        DespensaScreen(navController = navController)

    }
}