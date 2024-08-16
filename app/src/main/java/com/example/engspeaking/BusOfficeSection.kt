package com.example.engspeaking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
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
import com.example.engspeaking.components.FirstLecCard
import com.example.engspeaking.components.LectureCard
import com.example.engspeaking.components.BusTopicCard
import com.example.engspeaking.components.CourseItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusOfficeSection(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(3) }
    var selectedTopicIndex by remember { mutableStateOf(3) }

    // LazyListState 선언
    val tabListState = rememberLazyListState()
    val topicListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // 탭 선택 시 자동 스크롤 처리
    LaunchedEffect(selectedTabIndex) {
        coroutineScope.launch {
            tabListState.animateScrollToItem(selectedTabIndex)
        }
    }

    // 토픽 선택 시 자동 스크롤 처리
    LaunchedEffect(selectedTopicIndex) {
        coroutineScope.launch {
            topicListState.animateScrollToItem(selectedTopicIndex)
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("비지니스 영어") },
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

            // 탭 목록을 위한 LazyRow
            LazyRow(
                state = tabListState, // 상태 추가
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
                                selectedTabIndex = index
                                navController.navigate(route)
                            },
                        textColor = if (isSelected) Color.White else Color.Black,
                        fontSize = 14,
                        imageSize = 48
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            // 토픽 목록을 위한 LazyRow
            LazyRow(
                state = topicListState, // 상태 추가
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(listOf(
                    "인터뷰" to "bus_interview",
                    "발표" to "bus_presentation",
                    "회의" to "bus_meeting",
                    "일반 사무" to "bus_office"
                )) { index, (title, route) ->
                    val isSelected = selectedTopicIndex == index

                    BusTopicCard(
                        level = title,
                        navController = navController,
                        route = route,
                        selected = isSelected,
                        modifier = Modifier.width(80.dp)
                    ) {
                        selectedTopicIndex = index
                        navController.navigate(route)
                    }
                }
            }

            // 강의 제목 리스트
            val lectureTitles = listOf(
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
                    FirstLecCard(
                        title = lectureTitles[0],
                        subtitle = "Updated today",
                        navController = navController,
                        lectureId = "0",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                items(lectureTitles) { title ->
                    val index = lectureTitles.indexOf(title)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        LectureCard(
                            title = title,
                            subtitle = "Updated today",
                            modifier = Modifier.weight(1f),
                            navController = navController,
                            lectureId = index.toString()
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        if (index + 1 < lectureTitles.size) {
                            LectureCard(
                                title = lectureTitles[index + 1],
                                subtitle = "Updated today",
                                modifier = Modifier.weight(1f),
                                navController = navController,
                                lectureId = (index + 1).toString()
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
fun BusOfficeSectionPreview() {
    val navController = rememberNavController()
    BusOfficeSection(navController = navController)
}
