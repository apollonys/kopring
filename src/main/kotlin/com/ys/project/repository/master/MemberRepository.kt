package com.ys.project.repository.master

import com.ys.project.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<MemberEntity?, Long?>