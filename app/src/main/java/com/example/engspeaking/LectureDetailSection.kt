package com.example.engspeaking

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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem as ExoMediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LectureDetailSection(
    navController: NavHostController,
    lectureId: String?,
    lectureTitle: String? // Lecture title passed from the NavHost
) {
    val context = LocalContext.current
    val videoUrl = getVideoUrlForLecture(lectureId) // Function to get video URL based on lectureId

    // ExoPlayer instance to play the video
    val exoPlayer = ExoPlayer.Builder(context).build().apply {
        val mediaItem = ExoMediaItem.fromUri(Uri.parse(videoUrl)) // Construct MediaItem from video URL
        setMediaItem(mediaItem)
        prepare()
        playWhenReady = true
    }

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
                .padding(paddingValues) // Apply padding values from Scaffold
                .padding(16.dp) // Additional padding if needed
        ) {
            // Video Player
            AndroidView(factory = {
                PlayerView(it).apply {
                    player = exoPlayer
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Lecture ID: $lectureId", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Lecture Title: $lectureTitle", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
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
    return "https://www.example.com/video/$lectureId.mp4" // Example URL format
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun LectureDetailSectionPreview() {
    val navController = rememberNavController()
    Scaffold { innerPadding -> // Capture the contentPadding from Scaffold
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Apply the innerPadding to avoid overlapping
                .padding(16.dp) // Additional padding for internal spacing
        ) {
            Text(text = "Lecture ID: 0", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "강의 제목: 샘플 강의", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Do nothing for preview */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("질문에 대한 영문 답변하러 가기")
            }
        }
    }
}
