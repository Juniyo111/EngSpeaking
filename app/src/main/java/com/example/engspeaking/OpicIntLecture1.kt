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
import com.example.engspeaking.components.OpicLevelCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpicIntLecture1(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    var selectedOpicLevel by remember { mutableStateOf("INTERMEDIATE") }

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
                OpicLevelCard("NOVICE", navController, "opic_novice", selectedOpicLevel == "NOVICE") {
                    selectedOpicLevel = "NOVICE"
                }
                OpicLevelCard("INTERMEDIATE", navController, "opic_intermediate", selectedOpicLevel == "INTERMEDIATE") {
                    selectedOpicLevel = "INTERMEDIATE"
                }
                OpicLevelCard("ADVANCED", navController, "opic_advanced", selectedOpicLevel == "ADVANCED") {
                    selectedOpicLevel = "ADVANCED"
                }
            }

            // Video Placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp) // Height for the video placeholder
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                    .clickable { navController.navigate("opic_int_lecture1") }, // Link to the video
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Video Placeholder",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Lecture Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("오픽 | 주제 : Presentation", fontSize = 24.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(16.dp))

                LectureContentCard(
                    title = "Sample 강의 by Katie",
                    subtitle = "Updated Today",
                    description = "강의 내용:\n다운로드 [강좌 구매시]\n강의 정리 PDF | 학습 자료 | 기출-유사문제 및 답안",
                    navController = navController,
                    route = "opic_int_lecture1"
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "강좌 구매\n200,000 원 | 총 20개 강좌",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Latest Lectures
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    items((1..9).toList()) { index ->
                        OiLectureCardPreview("Title $index", "Updated today")
                    }
                }
            }
        }
    }
}

@Composable
fun OiLectureCardPreview(title: String, subtitle: String, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun LectureContentCard(
    title: String,
    subtitle: String,
    description: String,
    navController: NavHostController,
    route: String
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable { navController.navigate(route) }
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Text(description, fontSize = 14.sp, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OpicIntLecture1Preview() {
    val navController = rememberNavController()
    OpicIntLecture1(navController = navController)
}


