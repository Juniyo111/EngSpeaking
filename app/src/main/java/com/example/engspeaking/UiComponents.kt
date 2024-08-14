package com.example.engspeaking.components

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ConLevelCard(
    level: String,
    navController: NavHostController,
    route: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (selected) Color(0xFF000080) else Color(0xFFE0E0E0) // 선택된 경우 배경 색상을 변경
    val textColor = if (selected) Color.White else Color.Black // 선택된 경우 텍스트 색상을 변경

    Box(
        modifier = Modifier
            .clickable {
                onClick()
                navController.navigate(route)
            }
            .padding(8.dp)
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(level, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = textColor)
    }
}

@Composable
fun ConFirstLecCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    ConlectureId: String // 강의 ID를 받음
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("Conlecture/$ConlectureId/$formattedTitle")
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
fun ConLectureCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    ConlectureId: String
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("Conlecture/$ConlectureId/$formattedTitle")
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
fun BusFirstLecCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    BuslectureId: String // 강의 ID를 받음
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("Buslecture/$BuslectureId/$formattedTitle")
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
fun BusLectureCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    BuslectureId: String
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("Buslecture/$BuslectureId/$formattedTitle")
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
fun OpicLevelCard(
    level: String,
    navController: NavHostController,
    route: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (selected) Color(0xFF000080) else Color(0xFFE0E0E0) // 선택된 경우 배경 색상을 변경
    val textColor = if (selected) Color.White else Color.Black // 선택된 경우 텍스트 색상을 변경

    Box(
        modifier = Modifier
            .clickable {
                onClick()
                navController.navigate(route)
            }
            .padding(8.dp)
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(level, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = textColor)
    }
}

@Composable
fun OpicFirstLecCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    OpiclectureId: String // 강의 ID를 받음
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("Opiclecture/$OpiclectureId/$formattedTitle")
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
fun OpicLectureCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    OpiclectureId: String
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("Opiclecture/$OpiclectureId/$formattedTitle")
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
fun TosTopicCard(
    level: String,
    navController: NavHostController,
    route: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (selected) Color(0xFF000080) else Color(0xFFE0E0E0) // 선택된 경우 배경 색상을 변경
    val textColor = if (selected) Color.White else Color.Black // 선택된 경우 텍스트 색상을 변경

    Box(
        modifier = Modifier
            .clickable {
                onClick()
                navController.navigate(route)
            }
            .padding(8.dp)
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(level, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = textColor)
    }
}

@Composable
fun TosFirstLecCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    ToslectureId: String // 강의 ID를 받음
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("Toslecture/$ToslectureId/$formattedTitle")
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
fun TosLectureCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    ToslectureId: String
) {
    // 강의 제목에서 공백을 "_"로 바꿔서 경로에 사용
    val formattedTitle = title.replace(" ", "_")

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 강의 ID와 제목을 함께 경로에 전달
                navController.navigate("Toslecture/$ToslectureId/$formattedTitle")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}









