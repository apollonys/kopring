package com.ys.project.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import lombok.Builder
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Builder
class MemberJoinRequest {
    private val name: @NotNull(message = "이름") @Size(max = 20, message = "이름") String? = null
    private val password: @NotNull(message = "비밀번호") String? = null
    private val email: @NotNull(message = "이메일") @Size(max = 100, message = "이메일") String? = null
    private val sex: String? = null
}