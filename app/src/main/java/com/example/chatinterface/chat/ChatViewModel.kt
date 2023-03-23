package com.example.chatinterface.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicInteger

class ChatViewModel: ViewModel() {
    private val _chatMessages = mutableStateListOf<Message>()
        val chatMessages: List<Message>
            get() = _chatMessages

    var userOpenedChatID by mutableStateOf<String?>(null)
        private set

    private var messageId = AtomicInteger(0)

    fun newMessage(
        text: String,
        senderID: String,
    ){
        _chatMessages.add(
            element = Message(
                id = messageId.incrementAndGet(),
                date = LocalDateTime.now(),
                messageText = text,
                senderID = senderID
            )
        )
    }

    fun registerUser(id: String){
        userOpenedChatID = id
    }
}