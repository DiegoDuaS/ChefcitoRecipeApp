package com.example.chefcitorecipeapp.ui.PantallaInicio.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chefcitorecipeapp.Greeting
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioScreen(){

    var user by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Fondo),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Fondo),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(250.dp)
                    .background(color = ColorMain),
                contentAlignment = Alignment.Center,
            ){
                Image(
                    painter = painterResource(id = R.drawable.chefcitologo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Chefcito",
                style =  MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(vertical = 0.dp)
                    .padding(horizontal = 4.dp),
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Text(
                text = "Recipe App",
                style =  MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(vertical = 0.dp)
                    .padding(horizontal = 4.dp),
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                textStyle = MaterialTheme.typography.bodySmall,
                label = { Text("User") },
                singleLine = true
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                textStyle = MaterialTheme.typography.bodySmall,
                label = { Text("Password") },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = ColorMain)

            ) {
                Text("Entrar")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    ChefcitoRecipeAppTheme {
        InicioScreen()
    }
}