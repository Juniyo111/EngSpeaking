package com.example.engspeaking

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodayEngExpression() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "오늘의 영어 표현",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("오늘의 영어 표현 1: \"Break the ice\"", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
        Text("의미: 어색한 분위기를 깨다, 처음 만난 사람들과의 긴장감을 풀다.", fontSize = 16.sp, modifier = Modifier.padding(bottom = 8.dp))
        Text("예문: \"He told a joke to break the ice at the beginning of the meeting.\"", fontSize = 16.sp)
        // 추가로 필요한 영어 표현이나 내용을 여기에 추가합니다.
    }
}


