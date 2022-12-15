package com.iwfsg.board.global.common.entity

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity {
    @Column(name = "create_at")
    var createdAt: ZonedDateTime? = null

    @PrePersist
    fun prePersist() {
        createdAt = ZonedDateTime.now()
    }
}
