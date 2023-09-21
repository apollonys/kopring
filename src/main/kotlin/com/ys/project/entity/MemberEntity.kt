package com.ys.project.entity

import jakarta.persistence.*

@Entity
@Table(name = "MEMBER")
class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null

    @Column
    var name: String? = null
}