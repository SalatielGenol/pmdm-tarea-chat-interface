package com.example.chatinterface.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chatinterface.data.Message

@Composable
internal fun MessageCard(message: Message) {
    var isDateVisible by rememberSaveable { mutableStateOf(true) }
    Card(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(all = 10.dp)
            .sizeIn(minHeight = 50.dp),
        shape = if (message.isFromSender) {
            RoundedCornerShape(
                topStart = 15.dp,
                topEnd = 15.dp,
                bottomStart = 15.dp,
                bottomEnd = if (message.isLastMessage) 0.dp else 15.dp
            )
        } else {
            RoundedCornerShape(
                topStart = if (message.isLastMessage) 0.dp else 15.dp,
                topEnd = 15.dp,
                bottomStart = 15.dp,
                bottomEnd = 15.dp
            )
        },
        backgroundColor = if (message.isFromSender) {
            Color(0xFF03DAC5)
        } else {
            Color(0xFF87AF58)
        },
        elevation = 5.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(all = 10.dp),
        ) {
            Text(
                text = message.messageText,
                modifier = Modifier
                    .padding(all = 3.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = if (isDateVisible) getTimeElapsedFormatted(message.date) else getTimeFormatted(message.date),
                    modifier = Modifier
                        .padding(all = 3.dp)
                        .clickable { isDateVisible = !isDateVisible }
                )
            }
        }
    }
}