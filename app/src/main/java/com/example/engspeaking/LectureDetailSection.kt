package com.example.engspeaking

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LectureDetailSection(
    navController: NavHostController,
    lectureId: String?,
    lectureTitle: String? // Lecture title passed from the NavHost
) {
    // Get the current context to use with Intents
    val context = LocalContext.current
    // Get the video URL based on the lecture ID
    val videoUrl = getVideoUrlForLecture(lectureId)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(lectureTitle ?: "Lecture Details") },
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
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Lecture ID: $lectureId", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Lecture Title: $lectureTitle", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            // Button to Open YouTube Video
            Button(
                onClick = {
                    // Create an intent to open the YouTube video in a browser or YouTube app
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("Watch Video on YouTube")
            }

            // Navigate to Q&A Section
            Button(
                onClick = { navController.navigate("qandr") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("질문에 대한 영문 답변하러 가기")
            }
        }
    }
}

// Function to get video URL based on lecture ID
fun getVideoUrlForLecture(lectureId: String?): String {
    return when (lectureId) {
        "1" -> "https://www.youtube.com/watch?v=_wm3EELBJt4" // YouTube URL for Lecture ID 1
        "2" -> "https://www.youtube.com/watch?v=w1uDMcIXCnY" // Another YouTube URL for Lecture ID 2
        else -> "https://www.youtube.com/watch?v=w1uDMcIXCnY" // Default or fallback URL
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun LectureDetailSectionPreview() {
    val navController = rememberNavController()
    LectureDetailSection(navController = navController, lectureId = "1", lectureTitle = "Sample Lecture")
}
