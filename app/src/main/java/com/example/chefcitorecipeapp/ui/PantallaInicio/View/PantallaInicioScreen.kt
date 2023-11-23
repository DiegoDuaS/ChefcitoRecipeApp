package com.example.chefcitorecipeapp.ui.PantallaInicio.View

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chefcitorecipeapp.R
import com.example.chefcitorecipeapp.navigation.Screen
import com.example.chefcitorecipeapp.ui.FirebaseData.MySingleton
import com.example.chefcitorecipeapp.ui.PantallaInicio.Model.PantallaInicioViewModel
import com.example.chefcitorecipeapp.ui.theme.ChefcitoRecipeAppTheme
import com.example.chefcitorecipeapp.ui.theme.ColorMain
import com.example.chefcitorecipeapp.ui.theme.Fondo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioScreen(navController: NavController,
                 viewModel: PantallaInicioViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){

    val context = LocalContext.current
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val newuser = buildAnnotatedString {
        val text = stringResource(id = R.string.signin)
        append(text)
        val start = 0
        val end = text.length

        addStyle(
            SpanStyle(
                color = colorResource(id = R.color.blackinicio),
                textDecoration = TextDecoration.Underline,
            ),
            start,
            end
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id =R.color.fondo))
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id =R.color.fondo)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.fondo)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(250.dp)
                        .background(color = colorResource(id = R.color.colorMain)),
                    contentAlignment = Alignment.Center,
                ) {
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
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(vertical = 0.dp)
                        .padding(horizontal = 4.dp),
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.blackinicio)
                )
                Text(
                    text = stringResource(id = R.string.app_recetario),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(vertical = 0.dp)
                        .padding(horizontal = 4.dp),
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.blackinicio)
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
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
                OutlinedTextField(
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
                        viewModel.signInWithEmailAndPassword(user, password) { success ->
                            if (success) {
                                Toast.makeText(context, R.string.autenticando, Toast.LENGTH_SHORT).show()
                                viewModel.EncontrarIdDelDocumento(MySingleton.userID) { documentId ->
                                    if (documentId.isNotEmpty()) {
                                        viewModel.ObtenerParametrosDelDocumento(MySingleton.documentID)
                                        navController.navigate("Main") {
                                            popUpTo("Authentication") { inclusive = false }
                                        }
                                    }
                                }

                            } else {
                                Toast.makeText(context, R.string.incorrectsignin, Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.colorMain))
                )

                {
                    Text(
                        text = stringResource(id = R.string.enter),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(vertical = 0.dp)
                            .padding(horizontal = 4.dp),
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.white)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Text(
                        text = stringResource(id = R.string.questionusaurio),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(vertical = 0.dp)
                            .padding(horizontal = 4.dp),
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.blackinicio)
                    )
                    ClickableText(
                        text = newuser,
                        onClick ={
                            navController.navigate(Screen.SignIn.route){
                            }
                        },
                        style = MaterialTheme.typography.bodySmall
                    )
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    ChefcitoRecipeAppTheme {
        val navController = rememberNavController()
        InicioScreen(navController = navController)
    }
}