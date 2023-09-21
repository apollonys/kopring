package com.ys.project.controller

import com.ys.project.dto.MemberJoinRequest
import com.ys.project.repository.master.MemberRepository
import com.ys.project.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController (
    private val memberService: MemberService
){

    @GetMapping(value = ["/join"])
    fun setJoin(@RequestBody memberJoinRequest: @Valid MemberJoinRequest?): Boolean {
        memberService.insert();
        return true
    }
}