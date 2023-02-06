package com.example.chatinterface.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import com.example.chatinterface.data.Message

@Composable
internal fun LazyChat(paddingValues: PaddingValues, chatMessages: SnapshotStateList<Message>, state: LazyListState) {
    LazyColumn(state = state, modifier = Modifier.padding(paddingValues = paddingValues)) {
        items(chatMessages) {
            MessageRow(message = it)
        }
    }

}