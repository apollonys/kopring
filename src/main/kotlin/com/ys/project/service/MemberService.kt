package com.ys.project.service

import com.ys.project.entity.MemberEntity
import com.ys.project.repository.master.MemberRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@RequiredArgsConstructor
@Service
class MemberService (
    private val memberRepository: MemberRepository
){
    fun insert() {
        val memberEntity = MemberEntity()
        memberEntity.let { it.name="test" }
        memberRepository.save(memberEntity)
    }
}