package com.example.engspeaking

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QAndRScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Questions and Responses") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Text input area
            Text("아래에 질문에 대한 영문 답변을 작성해 주세요:")
            TextField(
                value = "", // Add state management for value
                onValueChange = { /* Handle input */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            // Correct Text button
            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text("AI 영문 수정 ")
            }

            // Display corrected text
            Text(
                text = "AI 영문 수정 결과:", // Update with actual corrected text
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Audio Upload and Processing Section (similar to your Streamlit app)
            Text("영문 음성 녹음 파일을 업로드하세요:")
            // Audio upload handling code here...
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QAndRPreview() {
    val navController = rememberNavController()
    QAndRScreen(navController)
}
