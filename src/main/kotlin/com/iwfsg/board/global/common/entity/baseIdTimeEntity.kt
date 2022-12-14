package com.iwfsg.board.global.common.entity

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class baseIdTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long = 0
}