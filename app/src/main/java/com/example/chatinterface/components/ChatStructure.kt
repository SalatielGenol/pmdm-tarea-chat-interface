package com.example.chatinterface.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatinterface.data.ChatData


@Composable
internal fun ChatStructure(chatData: ChatData){
    val chatDataState by remember { mutableStateOf(chatData) }
    var inputText by rememberSaveable { mutableStateOf("") }
    val listState = rememberLazyListState()
    Scaffold(topBar = {
        TopAppBar(title = {
            Icon(Icons.Filled.Face, contentDescription = "User icon")
            Text(text = chatData.userName, modifier = Modifier.padding(horizontal = 10.dp))
        }
    )},
    bottomBar = { BottomAppBar {
        OutlinedTextField(value = inputText, onValueChange = {inputText = it}, modifier = Modifier.weight(0.7f), singleLine = true)
        Button(onClick = {
            chatDataState.addMessage(messageText = inputText, isFromSender = true)
        }, modifier = Modifier.weight(0.2f)) {
            Text(text = "Enviar")
        }
    }}
    ) {
        LaunchedEffect(key1 = chatDataState.getAllMessages()){
            listState.scrollToItem(index = chatDataState.getAllMessages().lastIndex)
        }
        LazyChat(paddingValues = it, chatMessages = chatDataState.getAllMessages(), state = listState)
    }
}