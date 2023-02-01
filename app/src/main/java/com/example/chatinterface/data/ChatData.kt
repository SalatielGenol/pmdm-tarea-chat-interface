package com.example.chatinterface.data

import java.util.*

internal data class Message(
    val date: Date,
    val messageText: String,
    val isFromSender: Boolean
)

internal class ChatData(
    val userName: String
) {
    private val chatMessages: MutableList<Message> = mutableListOf()

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

    fun getAllMessages(): MutableList<Message> {
        return chatMessages
    }
}