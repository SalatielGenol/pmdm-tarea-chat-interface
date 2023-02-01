package com.example.chatinterface.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatinterface.data.ChatData


@Composable
internal fun ChatStructure(chatData: ChatData, content: @Composable (PaddingValues) -> Unit){
    Scaffold(topBar = {
        TopAppBar(title = {
            Icon(Icons.Filled.Face, contentDescription = "User icon")
            Text(text = chatData.userName, modifier = Modifier.padding(horizontal = 10.dp))
        }
    )}) {
        content(it)
    }
}