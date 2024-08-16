package com.example.engspeaking.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun CourseItem(
    navController: NavHostController,
    title: String,
    route: String,
    imageRes: Int,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Yellow,
    fontSize: Int = 16,
    imageSize: Int = 72
) {
    Column(
        modifier = modifier
            .width(150.dp)
            .clickable { navController.navigate(route) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image 컴포저블로 변경
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(imageSize.dp)  // 이미지 크기 설정
        )
        Text(text = title, fontSize = fontSize.sp, color = textColor)
    }
}


@Composable
fun ConLevelCard(
    level: String,
    navController: NavHostController,
    route: String,
    selected: Boolean,
    modifier: Modifier = Modifier, // Modifier 파라미터 추가
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .background(
                color = if (selected) Color(0xFF6FA3EF) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp), // padding을 Box 내부로 이동
        contentAlignment = Alignment.Center
    ) {
        Text(level, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BusTopicCard(
    level: String,
    navController: NavHostController,
    route: String,
    selected: Boolean,
    modifier: Modifier = Modifier, // Modifier 파라미터 추가
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .background(
                color = if (selected) Color(0xFF6FA3EF) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp), // padding을 Box 내부로 이동
        contentAlignment = Alignment.Center
    ) {
        Text(level, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun OpicLevelCard(
    level: String,
    navController: NavHostController,
    route: String,
    selected: Boolean,
    modifier: Modifier = Modifier, // Modifier 파라미터 추가
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .background(
                color = if (selected) Color(0xFF6FA3EF) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp), // padding을 Box 내부로 이동
        contentAlignment = Alignment.Center
    ) {
        Text(level, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun TosTopicCard(
    level: String,
    navController: NavHostController,
    route: String,
    selected: Boolean,
    modifier: Modifier = Modifier, // Modifier 파라미터 추가
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .background(
                color = if (selected) Color(0xFF6FA3EF) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp), // padding을 Box 내부로 이동
        contentAlignment = Alignment.Center
    ) {
        Text(level, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun FirstLecCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    lectureId: String // 강의 ID를 받음
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("lecture/$lectureId/$formattedTitle")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun LectureCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    lectureId: String
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("lecture/$lectureId/$formattedTitle")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}









