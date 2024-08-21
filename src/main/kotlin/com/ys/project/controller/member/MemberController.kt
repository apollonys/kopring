package com.ys.project.controller.member

import com.ys.project.dto.MemberRequest
import com.ys.project.dto.MemberResponse
import com.ys.project.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/test")
class MemberController (
    private val memberService: MemberService
){

    @PostMapping(value = ["/member"])
    fun setJoin(@RequestBody memberRequest: @Valid MemberRequest): Boolean {
        memberService.insert(memberRequest)
        return true
    }

    @GetMapping("/member/{id}")
    fun getMembers(@PathVariable id: Long): MemberResponse {
        return memberService.selectBy(id)
    }
}