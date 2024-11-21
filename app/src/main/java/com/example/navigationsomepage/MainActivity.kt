package com.example.navigationsomepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationsomepage.Navigation.MahasiswaApp
import com.example.navigationsomepage.model.Mahasiswa
import com.example.navigationsomepage.ui.theme.NavigationSomePageTheme
import com.example.navigationsomepage.ui.view.screen.MahasiswaFormView
import com.example.navigationsomepage.ui.view.screen.SplashView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSomePageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   MahasiswaApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationSomePageTheme {
        Greeting("Android")
    }
}