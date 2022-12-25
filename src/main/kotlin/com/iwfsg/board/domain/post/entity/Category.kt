package com.iwfsg.board.domain.post.entity

import com.iwfsg.board.global.common.entity.BaseIdEntity
import javax.persistence.Entity

@Entity
class Category (
    val title: String
): BaseIdEntity()