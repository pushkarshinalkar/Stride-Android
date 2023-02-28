package com.tutorial.courser.model.courses

data class CoursesItem(
    val c_big_image_link: String,
    val c_id: Int,
    val c_mid_image_link: String,
    val c_name: String,
    val c_about: String,
    val c_points: Int,
    val c_num_videos: Int,
    val c_is_featured: Boolean,
    val c_small_image_link: String,
    val c_total_time: String
)