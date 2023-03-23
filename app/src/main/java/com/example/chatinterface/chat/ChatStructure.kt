package com.example.chatinterface.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
internal fun ChatStructure() {
    val chatDataState by remember { mutableStateOf() }
    var inputText by rememberSaveable { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()


    Scaffold(topBar = {
        TopAppBar(title = {
            Icon(Icons.Filled.Face, contentDescription = "User icon")
            Text(text = chatDataState.userName, modifier = Modifier.padding(horizontal = 10.dp))
        }
        )
    },
        bottomBar = {
            BottomAppBar {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    singleLine = true,
                )
                IconButton(onClick = {
                    chatDataState.addMessage(messageText = inputText, isFromSender = true)
                    coroutineScope.launch { listState.scrollToItem(index = chatDataState.getAllMessages().lastIndex) }
                }) {
                    Icon(Icons.Filled.Send, contentDescription = "Send button")
                }
            }
        }
    ) {
        LaunchedEffect(key1 = chatDataState.getAllMessages()) {
            coroutineScope.launch { listState.scrollToItem(index = chatDataState.getAllMessages().lastIndex) }
        }
        LazyColumn(
            state = listState,
            modifier = Modifier.padding(paddingValues = it),
        ) {
            items(items = chatDataState.getAllMessages()) { message ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = if (message.isFromSender) {
                        Arrangement.End
                    } else {
                        Arrangement.Start
                    }
                ) {
                    MessageCard(message = message)
                }
            }
        }
    }
}