package com.ys.project.mapper

import com.ys.project.dto.MemberResponse
import com.ys.project.entity.MemberEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MemberMapper {
    fun toDto(entity: MemberEntity): MemberResponse
}