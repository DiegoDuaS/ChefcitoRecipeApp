package com.example.chefcitorecipeapp.ui.SignIn.View

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.navigation.Screen
import com.example.chefcitorecipeapp.ui.PantallaInicio.Model.PantallaInicioViewModel
import com.example.chefcitorecipeapp.ui.PantallaInicio.View.InicioScreen
import com.example.chefcitorecipeapp.ui.SignIn.Model.SingInViewModel
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SigninScreen(navController: NavController,
                 viewModel: SingInViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.fondo))
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.fondo)),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.fondo)),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Card(
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.fondo))
                        .width(300.dp)
                        .height(220.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.colorMain),
                    )
                ){
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = colorResource(id = R.color.colorMain)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.chefcitologo),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                        Text(
                            text = "Chefcito",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier
                                .padding(vertical = 0.dp)
                                .padding(horizontal = 4.dp),
                            textAlign = TextAlign.Center,
                            color = colorResource(id = R.color.white)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.fondo))
                        .width(300.dp)
                        .height(350.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.colorMain),
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = colorResource(id = R.color.colorMain)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(id = R.string.signin),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .padding(vertical = 0.dp)
                                .padding(horizontal = 4.dp),
                            textAlign = TextAlign.Center,
                            color = colorResource(id = R.color.white)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        TextField(
                            value = user,
                            onValueChange = { user = it },
                            textStyle = MaterialTheme.typography.bodySmall,
                            label = { Text(
                                text = stringResource(id = R.string.user),
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier
                                    .padding(vertical = 0.dp)
                                    .padding(horizontal = 4.dp),
                                textAlign = TextAlign.Center,
                                color = colorResource(id = R.color.blackinicio)
                            ) },
                            singleLine = true
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            textStyle = MaterialTheme.typography.bodySmall,
                            label = { Text(
                                text = stringResource(id = R.string.contrasena),
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier
                                    .padding(vertical = 0.dp)
                                    .padding(horizontal = 4.dp),
                                textAlign = TextAlign.Center,
                                color = colorResource(id = R.color.blackinicio)
                            )},
                            singleLine = true,
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )
                        Spacer(modifier = Modifier.height(16.dp))


                        Button(
                            onClick = {
                                viewModel.CreateUserWithEmailAndPassword(user,password){
                                    Toast.makeText(context, R.string.usercreatedsuc, Toast.LENGTH_LONG).show()
                                    navController.navigate(Screen.Login.route)

                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.white))
                        ){
                            Text(
                                text = stringResource(id = R.string.enter),
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier
                                    .padding(vertical = 0.dp)
                                    .padding(horizontal = 4.dp),
                                textAlign = TextAlign.Center,
                                color = colorResource(id = R.color.black)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(id = R.string.mensajestart),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .padding(vertical = 0.dp)
                                .padding(horizontal = 4.dp),
                            textAlign = TextAlign.Center,
                            color = colorResource(id = R.color.white)
                        )
                    }
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SigninScreenPreview() {
    ChefcitoRecipeAppTheme {
        val navController = rememberNavController()
        val signinview = SingInViewModel()
        SigninScreen(navController = navController, signinview)
    }
}