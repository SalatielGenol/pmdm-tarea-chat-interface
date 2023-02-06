package com.example.chatinterface.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.util.*

internal data class Message(
    val date: Date,
    val messageText: String,
    val isFromSender: Boolean
)

internal class ChatData(
    val userName: String
) {
    private val chatMessages = mutableStateListOf<Message>()

    fun addMessage(
        date: Date = Calendar.getInstance().time,
        messageText: String,
        isFromSender: Boolean = false
    ) {
        chatMessages.add(
            Message(
                date = date,
                messageText = messageText,
                isFromSender = isFromSender
            )
        )
    }

    fun getAllMessages(): SnapshotStateList<Message> {
        return chatMessages
    }
}