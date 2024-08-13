package com.example.engspeaking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.engspeaking.components.OpicFirstLecCard
import com.example.engspeaking.components.OpicLectureCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpicSection(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("오픽 OPIC") },
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

            // Opic Levels
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                com.example.engspeaking.components.OpicLevelCard(
                    "NOVICE",
                    navController,
                    "opic_novice",
                    selected = false, // 선택 상태 관리가 필요 없으므로 고정값으로 설정
                ) {
                    navController.navigate("opic_novice")
                }
                com.example.engspeaking.components.OpicLevelCard(
                    "INTERMEDIATE",
                    navController,
                    "opic_intermediate",
                    selected = false, // 선택 상태 관리가 필요 없으므로 고정값으로 설정
                ) {
                    navController.navigate("opic_intermediate")
                }
                com.example.engspeaking.components.OpicLevelCard(
                    "ADVANCED",
                    navController,
                    "opic_advanced",
                    selected = false, // 선택 상태 관리가 필요 없으므로 고정값으로 설정
                ) {
                    navController.navigate("opic_advanced")
                }
            }

            // 강의 제목 리스트
            val OpiclectureTitles = listOf(
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
                    OpicFirstLecCard(
                        title = OpiclectureTitles[0],
                        subtitle = "Updated today",
                        navController = navController,
                        OpiclectureId = "0",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                items(OpiclectureTitles) { title ->
                    val index = OpiclectureTitles.indexOf(title)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OpicLectureCard(
                            title = title,
                            subtitle = "Updated today",
                            modifier = Modifier.weight(1f),
                            navController = navController,
                            OpiclectureId = index.toString()
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        if (index + 1 < OpiclectureTitles.size) {
                            OpicLectureCard(
                                title = OpiclectureTitles[index + 1],
                                subtitle = "Updated today",
                                modifier = Modifier.weight(1f),
                                navController = navController,
                                OpiclectureId = (index + 1).toString()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OpicSectionPreview() {
    val navController = rememberNavController()
    OpicSection(navController = navController)
}
