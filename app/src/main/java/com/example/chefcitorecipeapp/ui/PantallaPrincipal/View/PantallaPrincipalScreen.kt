package com.example.chefcitorecipeapp.ui.PantallaPrincipal.View

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.ui.PantallaInicio.View.InicioScreen
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo
import com.example.chefcitorecipeapp.ui.theme.Tarjeta
import coil.compose.AsyncImage
import com.example.chefcitorecipeapp.navigation.Screen



data class BottomNavigationItem(
    val name:String,
    val iconoselected: ImageVector,
    val iconounselected: ImageVector,
    val ruta: String,
    )

//Clase provicional para preview
data class RecetasParaPreview(
    val name:String,
    val cocinero: String,
    val tiempo:String
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {

    //Lista provicional
    val recetas = listOf(
        RecetasParaPreview("Receta 1", "Chef 1", "30"),
        RecetasParaPreview("Receta 2", "Chef 2", "45"),
        RecetasParaPreview("Receta 3", "Chef 3", "20"),
        RecetasParaPreview("Receta 4", "Chef 4", "15"),
        RecetasParaPreview("Receta 5", "Chef 5", "120"),
    )

    val items = listOf(
        BottomNavigationItem(
            name = "Despensa",
            iconoselected = Icons.Filled.List,
            iconounselected = Icons.Outlined.List,
            ruta = Screen.Despensa.route
        ),
        BottomNavigationItem(
            name = "Nueva Receta",
            iconoselected = Icons.Filled.Add,
            iconounselected = Icons.Outlined.Add,
            ruta = Screen.NewReceta.route
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Fondo)
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(item.ruta)
                            },
                            label = {
                                    Text(
                                        text = item.name
                                    )
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        Badge()
                                    }
                                ) {
                                    Icon(
                                        imageVector =
                                        if (index == selectedItemIndex) {
                                            item.iconoselected
                                        } else {
                                            item.iconounselected
                                        },
                                        contentDescription = null
                                    )

                                }
                            }
                        )
                    }
                }
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Fondo)
                ) {
                    // Barra de aplicaciones
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .background(color = ColorMain),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Chefcito",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier
                                    .padding(vertical = 0.dp)
                                    .padding(horizontal = 4.dp),
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                            Image(
                                painter = painterResource(id = R.drawable.chefcitologo),
                                contentDescription = null,
                                modifier = Modifier.size(70.dp)
                            )
                        }
                    }
                    LazyColumn {
                        items(recetas){ receta ->
                            RecetaCard(receta = receta, navController)
                        }
                        item{
                            Spacer(modifier = Modifier.height(60.dp))
                        }
                    }


                }

            }
        )
    }
}




@Composable
fun RecetaCard(receta: RecetasParaPreview, navController: NavController ){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Fondo)
            .clickable {
                navController.navigate(Screen.Receta.route)
            },
        colors = CardDefaults.cardColors(
            containerColor = ColorMain
        ),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .background(color = Color.Transparent)
                    .align(Alignment.CenterVertically)
            ){
                AsyncImage(
                    //Imagen provicional para preview
                    model = "https://biencasero.clarin.com/advf/imagenes/4c28fc4fab6f6.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .size(130.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "${receta.name}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    textAlign = TextAlign.End,
                    color = Color.White
                )
                Text(
                    text = "por: ${receta.cocinero}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    color = Color.White,
                    textAlign = TextAlign.End,
                )
                Text(
                    text = "${receta.tiempo} minutos",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    color = Color.White,
                    textAlign = TextAlign.End,
                )
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ChefcitoRecipeAppTheme {
        val navController = rememberNavController()
        MainScreen(navController = navController)
    }
}