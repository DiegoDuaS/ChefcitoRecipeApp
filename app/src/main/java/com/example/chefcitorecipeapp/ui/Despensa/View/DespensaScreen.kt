package com.example.chefcitorecipeapp.ui.Despensa.View

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefcitorecipeapp.ui.PantallaPrincipal.View.RecetaCard
import com.example.chefcitorecipeapp.ui.PantallaPrincipal.View.RecetasParaPreview
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo

data class IngredientesParaPreview(
    val name:String,
    val cantidad: Int,
    val tipo: String
)

@Composable
fun DespensaScreen(navController: NavController){

    //Lista provicional
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
                .background(color = Color.Transparent),
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
                            text = "Despensa",
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
                        Spacer(modifier = Modifier.height(60.dp))
                    }
                    items(ingredientes){ ingrediente ->
                        IngredienteCard(ingrediente)
                    }
                    item{
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .background(color = ColorMain)
                                .height(80.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = ColorMain,
                            ),
                        ){
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(color = ColorMain),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Nuevo Ingrediente",
                                            style = MaterialTheme.typography.bodyMedium,
                                            modifier = Modifier
                                                .padding(vertical = 0.dp)
                                                .padding(horizontal = 4.dp),
                                            textAlign = TextAlign.Center,
                                            color = Color.White
                                        )
                                        Box(
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .padding(16.dp)
                                                .background(Color.White)
                                                .size(25.dp),
                                            contentAlignment = Alignment.Center,
                                        ){
                                            Text(
                                                text = "+",
                                                style = MaterialTheme.typography.bodySmall,
                                                modifier = Modifier
                                                    .padding(vertical = 0.dp)
                                                    .padding(horizontal = 4.dp),
                                                textAlign = TextAlign.Center,
                                                color = Color.Black
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun IngredienteCard(ingrediente: IngredientesParaPreview){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = ColorMain)
            .height(80.dp),
        colors = CardDefaults.cardColors(
            containerColor = ColorMain,
        ),
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "${ingrediente.name}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 0.dp)
                        .padding(horizontal = 4.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Button(
                            onClick = { (ingrediente.cantidad - 1) },
                            shape = CircleShape,
                            modifier = Modifier
                                .size(25.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        ) {
                            Text("-")
                        }
                        Text(
                            text = " \t ${ingrediente.cantidad} \t",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .padding(vertical = 0.dp)
                                .padding(horizontal = 4.dp),
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                        Button(
                            onClick = { (ingrediente.cantidad + 1) },
                            shape = CircleShape,
                            modifier = Modifier
                                .size(25.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        ) {
                            Text(
                                text = "+",
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier
                                    .padding(vertical = 0.dp)
                                    .padding(horizontal = 4.dp),
                                textAlign = TextAlign.Center,
                                color = Color.Black
                            )
                        }
                    }
                    Text(
                        text = "${ingrediente.tipo}",
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
fun DespensaScreenPreview() {
    ChefcitoRecipeAppTheme {
        val navController = rememberNavController()
        DespensaScreen(navController = navController)

    }
}