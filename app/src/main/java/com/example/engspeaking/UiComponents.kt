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
fun OiProficiencyLevelCard(level: String, navController: NavHostController, route: String, selected: Boolean = false, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable {
                onClick()
                navController.navigate(route)
            }
            .padding(8.dp)
            .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(level, fontSize = 12.sp, fontWeight = FontWeight.Bold) // Adjust font size to 12.sp
            if (selected) {
                Spacer(modifier = Modifier.width(4.dp))
                Icon(imageVector = Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
fun OiLectureCard(title: String, subtitle: String, modifier: Modifier = Modifier, navController: NavHostController, // Add NavHostController
                  route: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable { navController.navigate(route) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun TosProficiencyLevelCard(level: String, navController: NavHostController, route: String, selected: Boolean = false, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable {
                onClick()
                navController.navigate(route)
            }
            .padding(8.dp)
            .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(level, fontSize = 12.sp, fontWeight = FontWeight.Bold) // Adjust font size to 12.sp
            if (selected) {
                Spacer(modifier = Modifier.width(4.dp))
                Icon(imageVector = Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
fun TosLectureCard(title: String, subtitle: String, modifier: Modifier = Modifier, navController: NavHostController, // Add NavHostController
                  route: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable { navController.navigate(route) }
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
fun BusLectureCard(title: String, subtitle: String, modifier: Modifier = Modifier, navController: NavHostController, // Add NavHostController
                   route: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable { navController.navigate(route) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun ConversationLevelCard(level: String, navController: NavHostController, route: String, selected: Boolean,
                          modifier: Modifier = Modifier, // Modifier 파라미터 추가
                          onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable { navController.navigate(route) }
            .padding(8.dp)
            .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(level, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ConLectureCard(title: String, subtitle: String, modifier: Modifier = Modifier, navController: NavHostController, // Add NavHostController
                   route: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable { navController.navigate(route) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun ConFisrtLecCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    navController: NavHostController  // NavController를 받음
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                // 여기에 NavController를 사용한 네비게이션 로직 추가 가능
                // 예: navController.navigate("some_route")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}
