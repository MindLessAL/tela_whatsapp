package com.example.zapzap


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.zapzap.ui.theme.ZapZapTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZapZapTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MyTopBar(title = "ZapZap") }
    ) { innerPadding ->
        ChatsListScreen(modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(title: String) {
    TopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue, // Cor de fundo da TopBar
            titleContentColor = Color.White // Cor do título
        ),
        actions = {
            IconButton(onClick = { /* Ação da câmera */ }) {
                Icon(Icons.Default.CameraAlt, contentDescription = "Abrir câmera")
            }
            IconButton(onClick = { /* Ação do menu */ }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Abrir menu")
            }
        }
    )
}

@Composable
fun ChatsListScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Chats List",
            Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    ZapZapTheme {
        MainScreen()
    }
}
