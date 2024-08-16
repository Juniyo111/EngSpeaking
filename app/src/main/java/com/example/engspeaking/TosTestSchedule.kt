package com.example.engspeaking

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToeicTestSchedule() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "토스 시험 일정",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "여기에서 토스 시험일정에 대한 자세한 정보를 확인할 수 있습니다.",
            fontSize = 16.sp
        )
        // 필요한 추가 내용을 여기에 추가합니다.
    }
}


