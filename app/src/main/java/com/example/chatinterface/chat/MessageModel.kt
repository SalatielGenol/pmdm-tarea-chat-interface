package com.example.chatinterface.chat

import java.time.LocalDateTime

data class Message(
    val id: Int,
    val date: LocalDateTime,
    val messageText: String,
    val senderID: String
)
