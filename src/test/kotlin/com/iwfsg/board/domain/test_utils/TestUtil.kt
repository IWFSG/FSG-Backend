package com.iwfsg.board.domain.test_utils

object TestUtil {
    fun data() = TestDataUtil
    fun converter() = TestConverter

    object TestDataUtil {
        fun post() = PostDataUtil
    }
    object TestConverter {
        fun postConverter() = PostConverter
    }

}