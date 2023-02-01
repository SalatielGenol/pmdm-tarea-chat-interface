package com.example.chatinterface.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.chatinterface.data.Message
import java.text.Format
import java.util.*

@Composable
internal fun MessageRow(message: Message) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.isFromSender) Arrangement.End else Arrangement.Start
    ) {
        if (message.isFromSender) SenderMessageRow(message.messageText, message.date) else ReceiverMessageRow(message.messageText, message.date)
    }
}

@Composable
fun SenderMessageRow(messageText: String, messageDate: Date) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(all = 15.dp)
            .sizeIn(minHeight = 50.dp),
        shape = RoundedCornerShape(
            topStart = 15.dp,
            topEnd = 15.dp,
            bottomStart = 15.dp,
            bottomEnd = 0.dp
        ),
        backgroundColor = Color(0xFF03DAC5),
        elevation = 5.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(all = 10.dp),
        ) {
            Text(
                text = messageText,
                modifier = Modifier
                    .padding(all = 3.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = messageDate.toString(),
                    modifier = Modifier
                        .padding(all = 3.dp)
                )
            }
        }
    }
}

@Composable
fun ReceiverMessageRow(messageText: String, messageDate: Date) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(all = 15.dp)
            .sizeIn(minHeight = 50.dp),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 15.dp,
            bottomStart = 15.dp,
            bottomEnd = 15.dp
        ),
        backgroundColor = Color(0xFF87AF58),
        elevation = 5.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(all = 10.dp),
        ) {
            Text(
                text = messageText,
                modifier = Modifier
                    .padding(all = 3.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = messageDate.toString(),
                    modifier = Modifier
                        .padding(all = 3.dp)
                )
            }
        }
    }
}