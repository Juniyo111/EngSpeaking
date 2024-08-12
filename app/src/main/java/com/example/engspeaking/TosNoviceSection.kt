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
import com.example.engspeaking.components.TosProficiencyLevelCard
import com.example.engspeaking.components.TosLectureCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TosNoviceSection(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(1) }
    var selectedProficiencyLevel by remember { mutableStateOf("NOVICE")}

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("토익 스피킹") },
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
                TosProficiencyLevelCard("NOVICE", navController, "tos_novice", selectedProficiencyLevel == "NOVICE") {
                    selectedProficiencyLevel = "NOVICE"
                }
                TosProficiencyLevelCard("INTERMEDIATE", navController, "tos_intermediate", selectedProficiencyLevel == "INTERMEDIATE") {
                    selectedProficiencyLevel = "INTERMEDIATE"
                }
                TosProficiencyLevelCard("ADVANCED", navController, "tos_advanced", selectedProficiencyLevel == "ADVANCED") {
                    selectedProficiencyLevel = "ADVANCED"
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
                    LectureCard("Lecture 0", "Updated today", Modifier.fillMaxWidth()) // 첫 번째 항목
                }
                items((1..9 step 2).toList()) { index -> // 나머지 항목들을 두 개씩 한 줄에 표시
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TosLectureCard("Lecture $index", "Updated today", Modifier.weight(1f), navController = navController, route = "opic_int_lecture1")
                        Spacer(modifier = Modifier.width(8.dp))
                        if (index + 1 <= 9) {
                            TosLectureCard("Lecture ${index + 1}", "Updated today", Modifier.weight(1f), navController = navController, route = "opic_int_lecture1")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TosNoviceSectionPreview() {
    val navController = rememberNavController()
    TosNoviceSection(navController = navController)
}



