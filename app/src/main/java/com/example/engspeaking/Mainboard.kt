@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.engspeaking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.engspeaking.LectureDetailSection
import com.example.engspeaking.ui.theme.EngSpeakingTheme



class Mainboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EngSpeakingTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "mainboard") {
                    composable("mainboard") { MainScreen(navController = navController) }
                    composable("personal_info") { PersonalInfoScreen() }
                    composable("settings") { SettingsScreen() }
                    composable("search") { SearchScreen() }
                    composable("terms_of_service") { TermsOfServiceScreen() }
                    composable("privacy_policy") { PrivacyPolicyScreen() }
                    composable("hobbies_and_interests") { CourseDetailScreen("Hobbies and Interests") }
                    composable("bus_presentation") { CourseDetailScreen("Presentation") }
                    composable("opic") { OpicSection(navController = navController) }
                    composable("toeic") { TosSection(navController = navController) }
                    composable("conversation") { ConversationSection(navController = navController) }
                    composable("business") { BusinessSection(navController = navController) }
                    composable("opic_exam_schedule") { CourseDetailScreen("오픽 시험일정") }
                    composable("toeic_exam_schedule") { CourseDetailScreen("토스 시험일정") }
                    composable("today_english_expression") { CourseDetailScreen("오늘의 영어표현") }
                    composable("opic_intermediate") { OpicIntermediateSection(navController = navController) }
                    composable("opic_novice") { OpicNoviceSection(navController = navController) }
                    composable("opic_advanced") { OpicAdvancedSection(navController = navController)}
                    composable("tos_novice") { TosNoviceSection(navController = navController)}
                    composable("tos_intermediate") { TosNoviceSection(navController = navController)}
                    composable("tos_advanced") { TosNoviceSection(navController = navController)}
                    composable("bus_interview") { BusInterviewSection(navController = navController)}
                    composable("bus_presentation") { BusPresentationSection(navController = navController)}
                    composable("bus_meeting") { BusMeetingSection(navController = navController)}
                    composable("bus_office") { BusOfficeSection(navController = navController)}
                    composable("con_basic") { ConBasicSection(navController = navController)}
                    composable("con_intermediate") { ConIntermediateSection(navController = navController)}
                    composable("con_advanced") { ConAdvancedSection(navController = navController)}
                    composable("conversation") { ConversationSection(navController = navController) }
                    composable("opic") { OPICSectionMain(navController = navController) }
                    composable("toeic") { TOEICSection(navController = navController) }
                    composable("business") { BusinessEnglishSection(navController = navController) }
                    composable("latest_lecture") { LatestLectureSection(navController = navController) }
                    composable("speaking_material") { SpeakingStudyMaterialSection(navController = navController) }
                    composable("opic_exam_schedule") { OpicTestSchedule() }
                    composable("toeic_exam_schedule") { ToeicTestSchedule() }


                    composable("LectureDetailSection/{lectureId}/{lectureTitle}") { backStackEntry ->
                        val lectureId = backStackEntry.arguments?.getString("lectureId")
                        val lectureTitle = backStackEntry.arguments?.getString("lectureTitle")
                        LectureDetailSection(
                            navController = navController,
                            lectureId = lectureId,
                            lectureTitle = lectureTitle
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("SPEAKING CONTENT 101") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("personal_info") }) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "Personal Info")
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate("search") }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { navController.navigate("settings") }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80FF9B49))
                .padding(paddingValues)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "SPEAKING CONTENT 101",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    EngSpeakingCourseSection(navController)
                    Spacer(modifier = Modifier.height(16.dp))
                    OPICSectionMain(navController)
                    Spacer(modifier = Modifier.height(16.dp))
                    TOEICSection(navController)
                    Spacer(modifier = Modifier.height(16.dp))
                    BusinessEnglishSection(navController)
                    Spacer(modifier = Modifier.height(16.dp))
                    LatestLectureSection(navController)
                    Spacer(modifier = Modifier.height(16.dp))
                    SpeakingStudyMaterialSection(navController)
                }
            }
        }
    }
}

@Composable
fun EngSpeakingCourseSection(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFF6FA3EF), RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF828382), RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "ENG Speaking Course",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Color.White
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { CourseItem(navController, "오픽", "opic", R.drawable.ic_launcher_foreground) }
            item { CourseItem(navController, "토익 스피킹", "toeic", R.drawable.ic_launcher_foreground) }
            item { CourseItem(navController, "영어회화", "conversation", R.drawable.ic_launcher_foreground) }
            item { CourseItem(navController, "Business English", "business", R.drawable.ic_launcher_foreground) }
        }
    }
}

@Composable
fun CourseItem(navController: NavHostController, title: String, route: String, imageRes: Int) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .clickable { navController.navigate(route) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Text(text = title, fontSize = 16.sp, color = Color.Yellow)
    }
}

// CourseCard 함수 정의
@Composable
fun CourseCard(
    navController: NavHostController,
    lectureId: String,
    lectureTitle: String,
    image: Painter,
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .clickable { navController.navigate("lecture/$lectureId/$lectureTitle") }
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = description, fontSize = 14.sp, color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        IconButton(
            onClick = { /* Play video */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Play", tint = Color.Black)
        }
    }
}

// OPICSectionMain 함수 정의
@Composable
fun OPICSectionMain(navController: NavHostController) {
    val lectureTitles = listOf(
        "좋아하는 음악 또는 가수 묘사",
        "현재 살고 있는 집 묘사"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
            .clickable { navController.navigate("opic") }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "오픽 OPIC",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Color.Black
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { LevelCard(level = "Novice", modifier = Modifier.clickable { navController.navigate("opic_novice") } ) }
            item { LevelCard(level = "Intermediate", modifier = Modifier.clickable { navController.navigate("opic_intermediate") } ) }
            item { LevelCard(level = "Advanced", modifier = Modifier.clickable { navController.navigate("opic_advanced") } ) }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // 첫 번째 강의 카드
            item {
                CourseCard(
                    navController = navController,
                    lectureId = "1",  // 강의 ID
                    lectureTitle = lectureTitles[0],  // 첫 번째 강의 제목
                    image = painterResource(id = android.R.drawable.ic_menu_gallery),
                    title = "강사 1",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 건강"
                )
            }
            // 두 번째 강의 카드
            item {
                CourseCard(
                    navController = navController,
                    lectureId = "1",  // 강의 ID
                    lectureTitle = lectureTitles[1],  // 두 번째 강의 제목
                    image = painterResource(id = android.R.drawable.ic_menu_gallery),
                    title = "강사 1",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 운동"
                )
            }
        }
    }
}

// TOEIC Section 함수 정의
@Composable
fun TOEICSection(navController: NavHostController) {
    val lectureTitles = listOf(
        "사진 묘사",
        "듣고 질문에 답하기"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
            .clickable { navController.navigate("opic") }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "토익 TOEIC SPEAKING",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Color.Black
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { LevelCard(level = "Novice", modifier = Modifier.clickable { navController.navigate("opic_novice") } ) }
            item { LevelCard(level = "Intermediate", modifier = Modifier.clickable { navController.navigate("opic_intermediate") } ) }
            item { LevelCard(level = "Advanced", modifier = Modifier.clickable { navController.navigate("opic_advanced") } ) }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // 첫 번째 강의 카드
            item {
                CourseCard(
                    navController = navController,
                    lectureId = "1",  // 강의 ID
                    lectureTitle = lectureTitles[0],  // 첫 번째 강의 제목
                    image = painterResource(id = android.R.drawable.ic_menu_gallery),
                    title = "강사 1",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 여행 질문"
                )
            }
            // 두 번째 강의 카드
            item {
                CourseCard(
                    navController = navController,
                    lectureId = "1",  // 강의 ID
                    lectureTitle = lectureTitles[1],  // 두 번째 강의 제목
                    image = painterResource(id = android.R.drawable.ic_menu_gallery),
                    title = "강사 1",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 대중 교통 질문"
                )
            }
        }
    }
}

// Business Section 함수 정의
@Composable
fun BusinessEnglishSection(navController: NavHostController) {
    val lectureTitles = listOf(
        "비즈니스 영어 입문",
        "발표"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
            .clickable { navController.navigate("opic") }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "BUSINESS ENGLISH",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Color.Black
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { LevelCard(level = "인터뷰", modifier = Modifier.clickable { navController.navigate("bus_interview") } ) }
            item { LevelCard(level = "발표", modifier = Modifier.clickable { navController.navigate("bus_presentation") } ) }
            item { LevelCard(level = "회의", modifier = Modifier.clickable { navController.navigate("bus_meeting") } ) }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // 첫 번째 강의 카드
            item {
                CourseCard(
                    navController = navController,
                    lectureId = "1",  // 강의 ID
                    lectureTitle = lectureTitles[0],  // 첫 번째 강의 제목
                    image = painterResource(id = android.R.drawable.ic_menu_gallery),
                    title = "강사 1",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 인터뷰"
                )
            }
            // 두 번째 강의 카드
            item {
                CourseCard(
                    navController = navController,
                    lectureId = "1",  // 강의 ID
                    lectureTitle = lectureTitles[1],  // 두 번째 강의 제목
                    image = painterResource(id = android.R.drawable.ic_menu_gallery),
                    title = "강사 1",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 발표"
                )
            }
        }
    }
}

@Composable
fun LevelCard(level: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
            .clickable { /* Add navigation or action */ },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Text(text = level, fontSize = 16.sp, color = Color.Black)
    }
}

@Composable
fun CourseCard(navController: NavHostController, route: String, image: Painter, title: String, description: String) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .clickable { navController.navigate(route) }
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = description, fontSize = 14.sp, color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        IconButton(
            onClick = { /* Play video */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Play", tint = Color.Black)
        }
    }
}

@Composable
fun LatestLectureSection(navController: NavHostController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("최신 강의 소개", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
            Spacer(modifier = Modifier.height(8.dp))
            LectureItem(navController, "Hobbies and Interests", "hobbies_and_interests")
            Spacer(modifier = Modifier.height(8.dp))
            LectureItem(navController, "Presentation", "presentation")
        }
    }
}

@Composable
fun LectureItem(navController: NavHostController, title: String, route: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate(route) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurface)
                Text("상세:", fontSize = 14.sp, color = Color.Gray)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("오늘 • 23 min", fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
    }
}

@Composable
fun SpeakingStudyMaterialSection(navController: NavHostController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text("최신 업데이트", fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurface)
                        Text("스피킹 학습 자료", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    }
                }
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item { StudyMaterialItem(navController, "오픽 시험일정", "https://m.opic.or.kr/opics/servlet/controller.opic.site.receipt.AnnualScheduleServlet?p_process=select-list-mobile&p_tab=opic") }
                item { StudyMaterialItem(navController, "토스 시험일정", "https://www.toeicswt.co.kr/receipt/examSchList.php") }
                item { StudyMaterialItem(navController, "오늘의 영어표현", "today_english_expression") }
            }
        }
    }
}

@Composable
fun StudyMaterialItem(navController: NavHostController, title: String, route: String) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .clickable { navController.navigate(route) },  // 클릭 시 경로로 이동
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Text(text = title, fontSize = 16.sp, color = Color.Black)
    }
}

@Composable
fun CourseDetailScreen(title: String) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            // Add detailed content for the course here
            BasicText("$title 자세히")
        }
    }
}

@Composable
fun PersonalInfoScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("회원 정보", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            // Add personal information content here
            BasicText("회원 정보 페이지입니다.")
        }
    }
}

@Composable
fun SettingsScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("설정", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            // Add settings content here
            BasicText("앱 설정 페이지입니다.")
        }
    }
}

@Composable
fun SearchScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Search", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            // Add search content here
            BasicText("This is the search screen.")
        }
    }
}

@Composable
fun TermsOfServiceScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Terms of Service", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            // Add terms of service content here
            BasicText("This is the terms of service screen.")
        }
    }
}

@Composable
fun PrivacyPolicyScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Privacy Policy", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            // Add privacy policy content here
            BasicText("This is the privacy policy screen.")
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun MainboardPreview() {
    EngSpeakingTheme {
        val navController = rememberNavController()
        MainScreen(navController = navController)
    }
}
