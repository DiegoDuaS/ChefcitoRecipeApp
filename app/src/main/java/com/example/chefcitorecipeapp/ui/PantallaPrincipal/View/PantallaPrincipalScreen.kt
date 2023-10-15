package com.example.chefcitorecipeapp.ui.PantallaPrincipal.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.ui.PantallaInicio.View.InicioScreen
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo
import com.example.chefcitorecipeapp.ui.theme.Tarjeta
import coil.compose.AsyncImage

@Composable
fun MainScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Fondo),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = ColorMain),
            contentAlignment = Alignment.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ){
                Text(
                    text = "Chefcito",
                    style =  MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .padding(vertical = 0.dp)
                        .padding(horizontal = 4.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.chefcitologo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                )
            }
            LazyColumn {

                }
        }

    }
}

@Composable
fun RecetaCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Fondo)
            .clickable {
                //Mandar a Receta Page (Va a necesitar el Id de la receta)
            },
        colors = CardDefaults.cardColors(
            containerColor = Tarjeta
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
                    .size(150.dp)
                    .background(color = Color.Transparent)
                    .align(Alignment.CenterVertically)
            ){
                AsyncImage(
                    model = "https://biencasero.clarin.com/advf/imagenes/4c28fc4fab6f6.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Nombre",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    textAlign = TextAlign.End,
                    color = Color.White
                )
                Text(
                    text = "por: ",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    color = Color.White,
                    textAlign = TextAlign.End,
                )
                Text(
                    text = "Tiempo",
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
        RecetaCard()
    }
}