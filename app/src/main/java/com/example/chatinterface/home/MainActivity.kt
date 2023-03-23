package com.example.chatinterface.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.chatinterface.chat.ChatStructure
import com.example.chatinterface.ui.theme.ChatInterfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatInterfaceTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ChatStructure()
                }
            }
        }

    }
}