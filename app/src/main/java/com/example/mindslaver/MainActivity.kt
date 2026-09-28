package com.example.mindslaver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mindslaver.ui.theme.MindSlaverTheme

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()
    private val collectionViewModel: CollectionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindSlaverTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    if (authViewModel.isLoggedIn) {
                        CollectionScreen(
                            collectionViewModel = collectionViewModel,
                            onLogout = { authViewModel.logout() }
                        )
                    } else {
                        LoginScreen(
                            authViewModel = authViewModel,
                            onLoginSuccess = { /* Navigation state handled by ViewModel */ }
                        )
                    }
                }
            }
        }
    }
}
