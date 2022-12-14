package com.iwfsg.board.global.common.entity

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class baseTimeEntity {
    protected var createdAt: ZonedDateTime? = null

    @PrePersist
    fun prePersist() {
        createdAt = ZonedDateTime.now()
    }

}
