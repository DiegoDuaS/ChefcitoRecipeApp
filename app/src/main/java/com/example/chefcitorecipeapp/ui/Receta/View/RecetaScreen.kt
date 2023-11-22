package com.example.chefcitorecipeapp.ui.Receta.View

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.ui.PantallaPrincipal.View.Recipe
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo
import com.example.chefcitorecipeapp.ui.theme.Tarjeta

data class IngredientesParaPreview(
    val name:String,
    val cantidad: String,
    val tipo: String

)
@Composable
fun RecetaScreen(
    navController: NavController,
    recipe: Recipe
) {

}

@Composable
fun RecetaScreen(navController: NavController){



    //Variables provicionales para visualización de la pantalla
    val ingredientesParaPreview = listOf(
        IngredientesParaPreview("Harina", "1", "Tazas"),
        IngredientesParaPreview("Azúcar", "1", "Cucharadas"),
        IngredientesParaPreview("Huevos", "2", "Unidades"),
        IngredientesParaPreview("Leche", "1", "Tazas"),
        IngredientesParaPreview("Mantquilla", "1/2", "Tazas"),
    )
    val pasos = listOf(
        "Paso 1",
        "Paso 2",
        "Paso 3",
        "Paso 4",
        "Paso 5",
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
                    .fillMaxWidth(),
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
                        ){
                            Icon(
                                imageVector = Icons.Outlined.ArrowBack,
                                contentDescription = null
                            )
                        }
                        Text(
                            text = "'Nombre Receta'",
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
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Spacer(modifier = Modifier.height(16.dp))
                            AsyncImage(
                                model = "https://biencasero.clarin.com/advf/imagenes/4c28fc4fab6f6.jpg",
                                contentDescription = null,
                                modifier = Modifier
                                    .size(250.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(50.dp)
                                    .background(color = ColorMain),
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = stringResource(id = R.string.by_chef) + " Persona",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .padding(vertical = 0.dp)
                                        .padding(horizontal = 4.dp),
                                    textAlign = TextAlign.Center,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(50.dp)
                                    .background(color = ColorMain),
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = stringResource(id = R.string.preparation_time),
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .padding(vertical = 0.dp)
                                        .padding(horizontal = 4.dp),
                                    textAlign = TextAlign.Center,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            CardIngredientes(ingredients = ingredientesParaPreview)
                            CardPasos(pasos)
                        }
                    }
                }

            }
        }
    }
}


@Composable
fun CardIngredientes(ingredients: List<IngredientesParaPreview>){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Fondo),
        colors = CardDefaults.cardColors(
            containerColor = ColorMain
        ),
    ){
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = stringResource(id = R.string.ingredientes_titulo_newr),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(vertical = 0.dp)
                    .padding(horizontal = 4.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            ingredients.forEachIndexed { index, ingredient ->
                //ACA VA EL IF
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "${ingredient.name}",
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

@Composable
fun CardPasos(pasos: List<String>){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Fondo),
        colors = CardDefaults.cardColors(
            containerColor = ColorMain
        ),
    ){
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = stringResource(id = R.string.pasos_titulo_newr),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(vertical = 0.dp)
                    .padding(horizontal = 4.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "pasos", //Texto de pasos que pongas, hay que ponerle \n
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

@Preview(showBackground = true)
@Composable
fun RecetaScreenPreview() {
    ChefcitoRecipeAppTheme {

        val navController = rememberNavController()
        RecetaScreen(navController = navController)

    }
}

