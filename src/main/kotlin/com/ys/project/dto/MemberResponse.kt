package com.ys.project.dto

data class MemberResponse (
    var name: String? = null,
    val password: String?,
    val email: String?,
    val sex: String?
)