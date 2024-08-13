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
import com.example.engspeaking.components.BusLectureCard
import com.example.engspeaking.components.BusFirstLecCard

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
                edgePadding = 4.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf(
                    "오픽" to "opic_route",
                    "토스" to "toeic_route",
                    "일반회화" to "conversation_route",
                    "비즈니스영어" to "business_route",
                    "기타" to "etc_route"
                ).forEachIndexed { index, (title, route) ->
                    val isSelected = selectedTabIndex == index
                    Tab(
                        selected = isSelected,
                        onClick = {
                            selectedTabIndex = index
                            navController.navigate(route)
                        },
                        text = {
                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 0.5.dp, vertical = 4.dp) // 텍스트 주변의 패딩 조정
                                    .background(
                                        color = if (isSelected) Color.Blue else Color.Transparent,
                                        shape = RoundedCornerShape(12.dp) // 배경 모양을 둥글게 설정
                                    )
                                    .padding(horizontal =3.dp, vertical = 6.dp) // 배경 내부의 패딩 조정
                            ) {
                                Text(
                                    text = title,
                                    color = if (isSelected) Color.White else Color.Black,
                                    maxLines = 1,
                                    fontSize = 14.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
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


            // 강의 제목 리스트
            val BuslectureTitles = listOf(
                "Introduction to Business English",
                "Advanced Presentation Skills",
                "Meeting Etiquette",
                "Office Communication",
                "Negotiation Tactics",
                "Cultural Sensitivity in Business",
                "Email Writing Skills",
                "Customer Service Excellence"
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                item {
                    Text("최신 강의 소개", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                item {
                    BusFirstLecCard(
                        title = BuslectureTitles[0],
                        subtitle = "Updated today",
                        navController = navController,
                        BuslectureId = "0",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                items(BuslectureTitles) { title ->
                    val index = BuslectureTitles.indexOf(title)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BusLectureCard(
                            title = title,
                            subtitle = "Updated today",
                            modifier = Modifier.weight(1f),
                            navController = navController,
                            BuslectureId = index.toString()
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        if (index + 1 < BuslectureTitles.size) {
                            BusLectureCard(
                                title = BuslectureTitles[index + 1],
                                subtitle = "Updated today",
                                modifier = Modifier.weight(1f),
                                navController = navController,
                                BuslectureId = (index + 1).toString()
                            )
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

@Preview(showBackground = true)
@Composable
fun BusinessSectionPreview() {
    val navController = rememberNavController()
    BusinessSection(navController = navController)
}


