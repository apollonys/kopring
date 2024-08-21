package com.ys.project.service

import com.ys.project.dto.MemberRequest
import com.ys.project.dto.MemberResponse
import com.ys.project.entity.MemberEntity
import com.ys.project.mapper.MemberMapper
import com.ys.project.repository.master.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService (
    private val memberRepository: MemberRepository,
    private val memberMapper : MemberMapper
){
    fun insert(memberRequest: MemberRequest) {
        val memberEntity = MemberEntity()
        memberEntity.let { it.name=memberRequest.name }
        memberRepository.save(memberEntity)
    }

    fun selectBy(id: Long):MemberResponse {
        val memberEntity = memberRepository.findById(id).get()
        return memberMapper.toDto(memberEntity)
    }
}