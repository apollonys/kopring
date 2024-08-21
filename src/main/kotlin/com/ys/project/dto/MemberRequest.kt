package com.ys.project.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class MemberRequest(
    val name: @NotNull(message = "이름") @Size(max = 20, message = "이름") String,
    val password: @NotNull(message = "비밀번호") String,
    val email: @NotNull(message = "이메일") @Size(max = 100, message = "이메일") String,
    val sex: String
)