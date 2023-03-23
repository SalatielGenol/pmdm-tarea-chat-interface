package com.example.chatinterface.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.time.LocalDateTime
import java.util.*

internal data class Message(
    val date: LocalDateTime,
    val messageText: String,
    val isFromSender: Boolean,
    var isLastMessage: Boolean
)

internal class ChatData(
    val userName: String
) {
    private val chatMessages = mutableStateListOf<Message>()

    fun addMessage(
        date: LocalDateTime = LocalDateTime.now(),
        messageText: String,
        isFromSender: Boolean = false,
        isLastMessage: Boolean = true
    ) {
        if(chatMessages.isNotEmpty() && chatMessages.last().isFromSender == isFromSender){
            chatMessages.last().isLastMessage = false
        }
        chatMessages.add(
            Message(
                date = date,
                messageText = messageText,
                isFromSender = isFromSender,
                isLastMessage = isLastMessage
            )
        )
    }

    fun getAllMessages(): SnapshotStateList<Message> {
        return chatMessages
    }

    fun getMessageId(msg: Message): Int{
        return chatMessages.indexOf(msg)
    }

    fun changeLastMessageState(){
        //chatMessages.last().isLastMessage = !chatMessages.last().isLastMessage
    }
}