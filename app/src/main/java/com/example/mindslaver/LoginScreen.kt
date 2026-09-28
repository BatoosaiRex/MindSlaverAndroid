package com.example.mindslaver
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindslaver.ui.theme.MindSlaverTheme
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    onLoginSuccess: () -> Unit
){
    var isExpanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_android),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .then(
                    if (isExpanded) Modifier.fillMaxSize()
                    else Modifier.fillMaxWidth()
                )
                .animateContentSize()
                .clickable { isExpanded = !isExpanded }
        ) {

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "MindSlaver",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFD700),
                    fontFamily = CinzelDecorative,
                )
                Text(
                    text = "Mercado de TCG en Colombia",
                    fontSize = 15.sp,
                    color = Color(0xFFFFD700),
                    fontFamily = CinzelDecorative,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                        .padding(bottom = 24.dp)
                )

                OutlinedTextField(
                    value = authViewModel.email,
                    onValueChange = { authViewModel.email = it },
                    label = { Text("Usuario") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                        .
                        .background(Color.Black.copy(alpha = 0.4f), shape = RoundedCornerShape(4.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = authViewModel.password,
                    onValueChange = { authViewModel.password = it },
                    label = { Text("Contraseña") },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.Black.copy(alpha = 0.4f), shape = RoundedCornerShape(4.dp))
                )

                if (authViewModel.loginError != null) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = authViewModel.loginError!!,
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        authViewModel.login()
                        if (authViewModel.isLoggedIn) {
                            onLoginSuccess()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "Entrar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
val Bold = FontWeight.Bold
val CinzelDecorative = FontFamily(
    Font(R.font.cinzel_decorative, FontWeight.Normal),
    Font(R.font.cinzel_decorative_bold, FontWeight.Bold)
)

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MindSlaverTheme {
        LoginScreen(
            authViewModel = AuthViewModel(),
            onLoginSuccess = {}
        )
    }
}
