package com.example.chatinterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.chatinterface.components.ChatStructure
import com.example.chatinterface.components.LazyChat
import com.example.chatinterface.data.ChatData
import com.example.chatinterface.ui.theme.ChatInterfaceTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val anakin = ChatData(userName = "Anakin Skywalker")

        anakin.addMessage(messageText = "¿De verdad no quieres un gatito común?")
        anakin.addMessage(messageText = "si, si ya he dicho que cualquier gatito me encanta, simplemente es por el caracter del gato, y cuanto tiempo crees que debo tener a un gatito conmigo para acostumbrarlo a la casa y a mi?", isFromSender = true)
        anakin.addMessage(messageText = "Pues creo que con dos o tres semanas puedes dejarlo encaminado")
        anakin.addMessage(messageText = "Yo si fuera tu adoptaría alguna raza de gatos que sean más caseros. Yo tuve un siamés y se portaba muy bien (vivió 13 años).")
        anakin.addMessage(messageText = "Hombre, podría adoptar uno con un año o asi, no me importaría... no quiero que por un capricho de que sea un cachorro, el lo pase mal solo 10 horas al dia.", isFromSender = true)

        setContent {
            ChatInterfaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ChatStructure(chatData = anakin) {
                        LazyChat(paddingValues = it, anakin.getAllMessages())
                    }
                }
            }
        }

        anakin.getAllMessages().forEach(action = {
            println(it.messageText)
            println(it.date)
        })
    }
}