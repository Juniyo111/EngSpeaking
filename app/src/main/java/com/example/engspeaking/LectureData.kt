// LectureData.kt
package com.example.engspeaking

// Data class to represent a Lecture
data class Lecture(
    val lectureId: String,
    val lectureTitle: String
)

// Object to serve as a repository for lecture data
object LectureRepository {
    val lectures = listOf(
        Lecture("1", "비즈니스 영어 입문"),
        Lecture("2", "고급 발표 기술"),
        Lecture("3", "회의"),
        Lecture("4", "사무실 커뮤니케이션"),
        Lecture("5", "협의 기술"),
        Lecture("6", "비즈니스에서의 문화적 민감성"),
        Lecture("7", "이메일 작성 기술"),
        Lecture("8", "탁월한 고객 서비스"),
        Lecture("9", "나의 가족과 친구들"),
        Lecture("10", "나의 일상 생활"),
        Lecture("11", "취미와 여가 활동"),
        Lecture("12", "좋아하는 영화나 책 소개"),
        Lecture("13", "자주 가는 장소 묘사"),
        Lecture("14", "여행 경험"),
        Lecture("15", "나의 직업과 업무"),
        Lecture("16", "대중교통 이용 경험"),
        Lecture("17", "쇼핑 경험"),
        Lecture("18", "운동과 건강 관리"),
        Lecture("19", "기억에 남는 축제나 행사"),
        Lecture("20", "기술과 소셜 미디어 사용"),
        Lecture("21", "주거 환경 묘사"),
        Lecture("22", "학교 생활과 학습 경험"),
        Lecture("23", "외국어 학습 경험")
    )

    // Function to find a lecture by its ID
    fun findLectureById(lectureId: String): Lecture? {
        return lectures.find { it.lectureId == lectureId }
    }
}
