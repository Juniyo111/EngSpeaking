package com.example.engspeaking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.engspeaking.components.LectureCard
import com.example.engspeaking.components.FirstLecCard
import com.example.engspeaking.components.BusTopicCard
import com.example.engspeaking.components.CourseItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusinessSection(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(3) }
    var selectedTopicIndex by remember { mutableStateOf(-1) }

    val lectures = LectureRepository.lectures.filter { it.lectureId.toInt() in 1..8 }

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

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(listOf(
                    "오픽" to "opic",
                    "토스" to "toeic",
                    "일반회화" to "conversation",
                    "비즈니스영어" to "business"
                )) { index, (title, route) ->
                    // 선택 상태를 확인하여 색상을 변경
                    val isSelected = selectedTabIndex == index

                    CourseItem(
                        navController = navController,
                        title = title,
                        route = route,
                        imageRes = R.drawable.ic_launcher_foreground,
                        modifier = Modifier
                            .background(
                                color = if (isSelected) Color.Blue else Color.LightGray,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable {
                                selectedTabIndex = index  // 탭을 클릭하면 인덱스를 갱신
                                navController.navigate(route)
                            },
                        textColor = if (isSelected) Color.White else Color.Black,
                        fontSize = 14,
                        imageSize = 48
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            // Topic Levels
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)  // 간격을 균등하게 설정
            ) {
                itemsIndexed(listOf(
                    "인터뷰" to "bus_interview",
                    "발표" to "bus_presentation",
                    "회의" to "bus_meeting",
                    "일반 사무" to "bus_office"
                )) { index, (title, route) ->
                    // 선택된 항목 확인
                    val isSelected = selectedTopicIndex == index

                    com.example.engspeaking.components.BusTopicCard(
                        level = title,
                        navController = navController,
                        route = route,
                        selected = isSelected,  // 선택된 항목의 상태 전달
                        modifier = Modifier.width(80.dp)
                    ) {
                        // 클릭 시 선택 상태 업데이트 및 해당 경로로 이동
                        selectedTopicIndex = index
                        navController.navigate(route)
                    }
                }
            }

            // Retrieve lecture titles from LectureRepository
            val lectures = LectureRepository.lectures

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                item {
                    Text("최신 강의 소개", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                item {
                    FirstLecCard(
                        title = lectures[0].lectureTitle,
                        subtitle = "Updated today",
                        navController = navController,
                        lectureId = lectures[0].lectureId,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                items(lectures) { lecture ->
                    val index = lectures.indexOf(lecture)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        LectureCard(
                            title = lecture.lectureTitle,
                            subtitle = "Updated today",
                            modifier = Modifier.weight(1f),
                            navController = navController,
                            lectureId = lecture.lectureId
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        if (index + 1 < lectures.size) {
                            LectureCard(
                                title = lectures[index + 1].lectureTitle,
                                subtitle = "Updated today",
                                modifier = Modifier.weight(1f),
                                navController = navController,
                                lectureId = lectures[index + 1].lectureId
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
fun BusinessSectionPreview() {
    val navController = rememberNavController()
    BusinessSection(navController = navController)
}


