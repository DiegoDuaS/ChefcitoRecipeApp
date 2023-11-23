package com.example.chefcitorecipeapp.ui.Receta.View

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.ui.Receta.Model.RecetaViewModel
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo


data class RecipeParameters(
    var Ajo: Boolean = false,
    var Arroz: Boolean = false,
    var Carne_Molida: Boolean = false,
    var Cebolla: Boolean = false,
    var Harina: Boolean = true,
    var Huevos: Boolean = false,
    var ImageUrl: String = "",
    var Leche: Boolean = false,
    var Nombre_Receta: String = "",
    var Papa: Boolean = false,
    var Pasos: String = "",
    var Pasta: Boolean = false,
    var Pimienta: Boolean = false,
    var Pollo: Boolean = false,
    var Post_id: String = "",
    var Preparation_Time: String = "",
    var Nombre_de_chef: String = "",
    var Sal: Boolean = false
)

@Composable
fun RecetaScreen(navController: NavController,
                 viewModel: RecetaViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

){
    var navBackStackEntry = navController.currentBackStackEntryAsState().value
    var id = navBackStackEntry?.arguments?.getString("id")
    val recipeParameters by viewModel.recipeParameters.observeAsState()
    var localCopyOfRecipeParameters: RecipeParameters? = null
    val ingredientesParaPreview = remember { mutableStateListOf<String>() }



    LaunchedEffect(id) {
        id?.let { viewModel.getRecipeParameters(it) }
    }
    recipeParameters?.let {

    }

    recipeParameters?.let { params ->
        localCopyOfRecipeParameters = params.copy()

        ingredientesParaPreview.clear()
        ingredientesParaPreview.addAll(viewModel.getTrueIngredients(localCopyOfRecipeParameters!!))

        PantallaReceta(navController, localCopyOfRecipeParameters!!,ingredientesParaPreview)
    }

    }



@SuppressLint("UnrememberedMutableState")
@Composable
fun PantallaReceta(
    navController: NavController,
    LocalCopy: RecipeParameters,
    ingredientesParaPreview: SnapshotStateList<String>
){
    val pasos = formatSteps(LocalCopy.Pasos)


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id =R.color.fondo))
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
                        .background(color = colorResource(id = R.color.colorMain)),
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
                            text = LocalCopy.Nombre_Receta,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .padding(vertical = 0.dp)
                                .padding(horizontal = 4.dp),
                            textAlign = TextAlign.Center,
                            color = colorResource(id = R.color.white)
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
                                model = LocalCopy.ImageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(250.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(50.dp)
                                    .background(color = colorResource(id = R.color.colorMain)),
                                contentAlignment = Alignment.Center
                            ){
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = stringResource(id = R.string.by_chef) + LocalCopy.Nombre_de_chef,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .padding(vertical = 0.dp)
                                        .padding(horizontal = 4.dp),
                                    textAlign = TextAlign.Center,
                                    color = colorResource(id = R.color.white)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(50.dp)
                                    .background(color = colorResource(id = R.color.colorMain)),
                                contentAlignment = Alignment.Center
                            ){
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = stringResource(id = R.string.preparation_time)+LocalCopy.Preparation_Time + " min",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .padding(vertical = 0.dp)
                                        .padding(horizontal = 4.dp),
                                    textAlign = TextAlign.Center,
                                    color = colorResource(id = R.color.white)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
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
fun CardIngredientes(ingredients: List<String>){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = colorResource(id =R.color.fondo)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.colorMain)
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
                color = colorResource(id = R.color.white)
            )
            ingredients.forEachIndexed { index, ingredient ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "- ${ingredient}",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(vertical = 0.dp)
                            .padding(horizontal = 4.dp),
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.white),
                        softWrap = true
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
            .background(color = colorResource(id = R.color.fondo)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.colorMain)
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
                color = colorResource(id = R.color.white)
            )
            pasos.forEachIndexed { index, paso ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${paso}",
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
fun RecetaScreenPreview() {
    ChefcitoRecipeAppTheme {

        val navController = rememberNavController()
        val ViewModel = RecetaViewModel()
        RecetaScreen(navController = navController,ViewModel)

    }
}

fun formatSteps(steps: String): List<String> {
    return steps.split('$')
        .filter { it.isNotBlank() }
        .mapIndexed { index, step -> "${index + 1}. ${step.trim()}" }
}
