package com.example.chatinterface.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.chatinterface.data.Message

@Composable
internal fun LazyChat(paddingValues: PaddingValues, chatMessages: MutableList<Message>) {
    LazyColumn(modifier = Modifier.padding(paddingValues = paddingValues)) {
        chatMessages.forEach(action = {
            item {
                MessageRow(it.copy())
            }
        })
    }

}