package com.example.engspeaking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.engspeaking.components.BusTopicCard
import com.example.engspeaking.components.TosLectureCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusinessSection(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(3) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("비즈니스영어", fontWeight = FontWeight.Bold, color = Color(0xFF00A86B)) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: Handle more options */ }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { navController.navigate("mainboard") }) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                }
                Spacer(modifier = Modifier.weight(1f, true))
                TextButton(onClick = { navController.navigate("terms_of_service") }) {
                    Text("이용약관")
                }
                Spacer(modifier = Modifier.weight(1f, true))
                TextButton(onClick = { navController.navigate("privacy_policy") }) {
                    Text("개인정보처리방침")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFDD0)) // Background color
                .padding(paddingValues)
        ) {
            // Scrollable Tab Row
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf(
                    "오픽" to "opic_route",
                    "토스" to "toeic_route",
                    "일반회화" to "conversation_route",
                    "비즈니스영어" to "business_route",
                    "기타" to "etc_route"
                ).forEachIndexed { index, (title, route) ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                            navController.navigate(route)
                        },
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                if (selectedTabIndex == index) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                }
                                Text(title, maxLines = 1, fontSize = 14.sp)
                            }
                        }
                    )
                }
            }

            // Proficiency Levels
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                com.example.engspeaking.components.BusTopicCard(
                    "인터뷰",
                    navController,
                    "bus_interview",
                    selected = false, // 선택 상태 관리가 필요 없으므로 고정값으로 설정
                    modifier = Modifier.width(80.dp)
                ) {
                    // 선택 상태를 업데이트할 필요가 없으므로 이 부분도 삭제 가능
                    navController.navigate("bus_interview")
                }
                com.example.engspeaking.components.BusTopicCard(
                    "발표",
                    navController,
                    "bus_presentation",
                    selected = false, // 선택 상태 관리가 필요 없으므로 고정값으로 설정
                    modifier = Modifier.width(80.dp)
                ) {
                    // 선택 상태를 업데이트할 필요가 없으므로 이 부분도 삭제 가능
                    navController.navigate("bus_presentation")
                }
                com.example.engspeaking.components.BusTopicCard(
                    "회의",
                    navController,
                    "bus_meeting",
                    selected = false, // 선택 상태 관리가 필요 없으므로 고정값으로 설정
                    modifier = Modifier.width(80.dp)
                ) {
                    // 선택 상태를 업데이트할 필요가 없으므로 이 부분도 삭제 가능
                    navController.navigate("bus_meeting")
                }
                com.example.engspeaking.components.BusTopicCard(
                    "일반 사무",
                    navController,
                    "bus_office",
                    selected = false, // 선택 상태 관리가 필요 없으므로 고정값으로 설정
                    modifier = Modifier.width(80.dp)
                ) {
                    // 선택 상태를 업데이트할 필요가 없으므로 이 부분도 삭제 가능
                    navController.navigate("bus_office")
                }
            }


            // Latest Lectures
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                item {
                    Text("최신 강의 소개", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                item {
                    BusinessLectureCard("Lecture 0", "Updated today", Modifier.fillMaxWidth()) // 첫 번째 항목
                }
                items((1..9 step 2).toList()) { index -> // 나머지 항목들을 두 개씩 한 줄에 표시
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BusinessLectureCard("Lecture $index", "Updated today", Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(8.dp))
                        if (index + 1 <= 9) {
                            BusinessLectureCard("Lecture ${index + 1}", "Updated today", Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessProficiencyLevelCard(level: String, navController: NavHostController, route: String) {
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
fun BusinessLectureCard(title: String, subtitle: String, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessSectionPreview() {
    val navController = rememberNavController()
    BusinessSection(navController = navController)
}


