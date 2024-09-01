@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.engspeaking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import com.example.engspeaking.ui.theme.EngSpeakingTheme
import com.example.engspeaking.components.CourseItem



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
                    composable("tos_intermediate") { TosIntermediateSection(navController = navController)}
                    composable("tos_advanced") { TosAdvancedSection(navController = navController)}
                    composable("bus_interview") { BusInterviewSection(navController = navController)}
                    composable("bus_presentation") { BusPresentationSection(navController = navController)}
                    composable("bus_meeting") { BusMeetingSection(navController = navController)}
                    composable("bus_office") { BusOfficeSection(navController = navController)}
                    composable("con_basic") { ConBasicSection(navController = navController)}
                    composable("con_intermediate") { ConIntermediateSection(navController = navController)}
                    composable("con_advanced") { ConAdvancedSection(navController = navController)}
                    composable("latest_lecture") { LatestLectureSection(navController = navController) }
                    composable("speaking_material") { SpeakingStudyMaterialSection(navController = navController) }
                    composable("opic_exam_schedule") { OpicTestSchedule() }
                    composable("toeic_exam_schedule") { ToeicTestSchedule() }
                    composable("qandr") { QAndRScreen(navController = navController) }


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
                title = { },
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
                .padding(8.dp)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(8.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
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
                    Spacer(modifier = Modifier.height(8.dp))
                    EngSpeakingCourseSection(navController)
                    Spacer(modifier = Modifier.height(8.dp))
                    OPICSection(navController)
                    Spacer(modifier = Modifier.height(8.dp))
                    TOEICSection(navController)
                    Spacer(modifier = Modifier.height(8.dp))
                    BusinessEnglishSection(navController)
                    Spacer(modifier = Modifier.height(8.dp))
                    LatestLectureSection(navController)
                    Spacer(modifier = Modifier.height(8.dp))
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
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            item { CourseItem(navController, "오픽", "opic", R.drawable.opic_logo) }
            item { CourseItem(navController, "토익 스피킹", "toeic", R.drawable.tos_logo) }
            item { CourseItem(navController, "영어회화", "conversation", R.drawable.con_logo) }
            item { CourseItem(navController, "Business English", "business", R.drawable.bus_logo) }
        }
    }
}

// OPICSection 함수 정의
@Composable
fun OPICSection(navController: NavHostController) {
    val lectureTitles = listOf(
        "좋아하는 음악 또는 가수 묘사",
        "현재 살고 있는 집 묘사"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
    ) {
        // 상단 Row: 오픽 OPIC 섹션 제목과 아이콘
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

        // 레벨 카드 리스트: Novice, Intermediate, Advanced
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                // Novice 레벨 카드에 이미지 추가
                LevelCard(
                    level = "Novice",
                    imageRes = R.drawable.fluency_level, // 예시 이미지 리소스 ID
                    modifier = Modifier.clickable { navController.navigate("opic_novice") }
                )
            }
            item {
                // Intermediate 레벨 카드에 이미지 추가
                LevelCard(
                    level = "Intermediate",
                    imageRes = R.drawable.fluency_level, // 예시 이미지 리소스 ID
                    modifier = Modifier.clickable { navController.navigate("opic_intermediate") }
                )
            }
            item {
                // Advanced 레벨 카드에 이미지 추가
                LevelCard(
                    level = "Advanced",
                    imageRes = R.drawable.fluency_level, // 예시 이미지 리소스 ID
                    modifier = Modifier.clickable { navController.navigate("opic_advanced") }
                )
            }
        }

        // 강의 카드 리스트
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
                    image = painterResource(id = R.drawable.instructor_1),  // 예시 이미지 리소스 ID
                    title = "강사 1",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 인터뷰"
                )
            }
            // 두 번째 강의 카드
            item {
                CourseCard(
                    navController = navController,
                    lectureId = "2",  // 강의 ID
                    lectureTitle = lectureTitles[1],  // 두 번째 강의 제목
                    image = painterResource(id = R.drawable.instructor_2),  // 예시 이미지 리소스 ID
                    title = "강사 2",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 발표"
                )
            }
        }
    }
}


@Composable
fun TOEICSection(navController: NavHostController) {
    val lectureTitles = listOf(
        "좋아하는 음악 또는 가수 묘사",
        "현재 살고 있는 집 묘사"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
    ) {
        // 상단 Row: 오픽 OPIC 섹션 제목과 아이콘
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "토익 스피킹",
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

        // 레벨 카드 리스트: Novice, Intermediate, Advanced
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                // Novice 레벨 카드에 이미지 추가
                LevelCard(
                    level = "Novice",
                    imageRes = R.drawable.fluency_level, // 예시 이미지 리소스 ID
                    modifier = Modifier.clickable { navController.navigate("tos_novice") }
                )
            }
            item {
                // Intermediate 레벨 카드에 이미지 추가
                LevelCard(
                    level = "Intermediate",
                    imageRes = R.drawable.fluency_level, // 예시 이미지 리소스 ID
                    modifier = Modifier.clickable { navController.navigate("tos_intermediate") }
                )
            }
            item {
                // Advanced 레벨 카드에 이미지 추가
                LevelCard(
                    level = "Advanced",
                    imageRes = R.drawable.fluency_level, // 예시 이미지 리소스 ID
                    modifier = Modifier.clickable { navController.navigate("tos_advanced") }
                )
            }
        }

        // 강의 카드 리스트
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
                    image = painterResource(id = R.drawable.instructor_1),  // 예시 이미지 리소스 ID
                    title = "강사 1",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 인터뷰"
                )
            }
            // 두 번째 강의 카드
            item {
                CourseCard(
                    navController = navController,
                    lectureId = "2",  // 강의 ID
                    lectureTitle = lectureTitles[1],  // 두 번째 강의 제목
                    image = painterResource(id = R.drawable.instructor_2),  // 예시 이미지 리소스 ID
                    title = "강사 2",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 발표"
                )
            }
        }
    }
}



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
    ) {
        // 상단 Row: BUSINESS ENGLISH 섹션 제목과 아이콘
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

        // 레벨 카드 리스트: 인터뷰, 발표, 회의
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                // 인터뷰 레벨 카드에 이미지 추가
                LevelCard(
                    level = "인터뷰",
                    imageRes = R.drawable.interview,
                    imageSize = 100,
                    modifier = Modifier.clickable { navController.navigate("bus_interview") }
                )
            }
            item {
                // 발표 레벨 카드에 이미지 추가
                LevelCard(
                    level = "발표",
                    imageRes = R.drawable.presentation,
                    imageSize = 100,
                    modifier = Modifier.clickable { navController.navigate("bus_presentation") }
                )
            }
            item {
                // 회의 레벨 카드에 이미지 추가
                LevelCard(
                    level = "회의",
                    imageRes = R.drawable.meeting,
                    imageSize = 100,
                    modifier = Modifier.clickable { navController.navigate("bus_meeting") }
                )
            }
            item {
                // 일반 사무 레벨 카드에 이미지 추가
                LevelCard(
                    level = "일반 사무",
                    imageRes = R.drawable.office,
                    imageSize = 100,
                    modifier = Modifier.clickable { navController.navigate("bus_office") }
                )
            }
        }

        // 강의 카드 리스트
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
                    image = painterResource(id = R.drawable.instructor_1),  // 예시 이미지 리소스 ID
                    title = "강사 1",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 인터뷰"
                )
            }
            // 두 번째 강의 카드
            item {
                CourseCard(
                    navController = navController,
                    lectureId = "2",  // 강의 ID
                    lectureTitle = lectureTitles[1],  // 두 번째 강의 제목
                    image = painterResource(id = R.drawable.instructor_2),  // 예시 이미지 리소스 ID
                    title = "강사 2",  // 실제 강사 이름이나 강의 이름을 사용할 수 있음
                    description = "샘플 | 주제: 발표"
                )
            }
        }
    }
}

// 수정된 LevelCard 함수
@Composable
fun LevelCard(level: String, imageRes: Int, modifier: Modifier = Modifier, imageSize: Int = 64) {
    Column(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 이미지 리소스를 표시
        Image(
            painter = painterResource(id = imageRes),  // 이미지 리소스 추가
            contentDescription = null,
            modifier = Modifier.size(imageSize.dp)
        )
        Text(text = level, fontSize = 16.sp, color = Color.Black)
    }
}

// CourseCard 함수 정의
@Composable
fun CourseCard(
    navController: NavHostController,
    lectureId: String,
    lectureTitle: String,
    image: Painter,  // Image 컴포저블로 표시할 이미지를 받습니다.
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
            // Image 컴포저블로 변경
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(64.dp)  // 이미지 크기 설정
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
            LectureItem(navController, "Hobbies and Interests", "hobbies_and_interests", imageRes = R.drawable.hobbies_1, imageSize = 100)
            Spacer(modifier = Modifier.height(8.dp))
            LectureItem(navController, "Presentation", "presentation", imageRes = R.drawable.presenation_2, imageSize = 100)
        }
    }
}

@Composable
fun LectureItem(
    navController: NavHostController,
    title: String,
    route: String,
    imageRes: Int, // 이미지 리소스 ID를 받는 매개변수
    description: String = "상세:", // 상세 정보 텍스트를 기본값으로 설정
    timeInfo: String = "오늘 • 23 min", // 시간 정보 텍스트를 기본값으로 설정
    imageSize: Int = 72 // 이미지 크기를 동적으로 설정할 수 있도록 기본값 설정
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate(route) }, // 클릭 시 지정된 경로로 이동
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // 이미지 리소스를 표시하는 Image 컴포넌트
            Image(
                painter = painterResource(id = imageRes), // 이미지 리소스를 받아서 표시
                contentDescription = null,
                modifier = Modifier.size(imageSize.dp) // 이미지 크기 설정
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = timeInfo,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
        // 화살표 아이콘
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
                        painter = painterResource(id = R.drawable.materials),
                        contentDescription = null,
                        modifier = Modifier.size(70.dp)
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
                item {
                    StudyMaterialItem(
                        navController = navController,
                        title = "오픽 시험일정",
                        route = "https://m.opic.or.kr/opics/servlet/controller.opic.site.receipt.AnnualScheduleServlet?p_process=select-list-mobile&p_tab=opic",
                        imageRes = R.drawable.opic_logo // 오픽 시험일정 이미지 리소스
                    )
                }
                item {
                    StudyMaterialItem(
                        navController = navController,
                        title = "토스 시험일정",
                        route = "https://www.toeicswt.co.kr/receipt/examSchList.php",
                        imageRes = R.drawable.tos_logo // 토익 시험일정 이미지 리소스
                    )
                }
                item {
                    StudyMaterialItem(
                        navController = navController,
                        title = "오늘의 영어표현",
                        route = "today_english_expression",
                        imageRes = R.drawable.today // 오늘의 영어표현 이미지 리소스
                    )
                }
            }
        }
    }
}

@Composable
fun StudyMaterialItem(
    navController: NavHostController,
    title: String,
    route: String,
    imageRes: Int // 이미지 리소스 ID를 받는 매개변수 추가
) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .clickable { navController.navigate(route) },  // 클릭 시 경로로 이동
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes), // 전달받은 이미지 리소스 사용
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
