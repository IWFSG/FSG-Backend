package com.iwfsg.board.domain.test_utils

object TestUtil {
    fun data() = TestDataUtil
    fun converter() = TestConverter

    object TestDataUtil {
        fun post() = PostDataUtil
        fun user() = UserDataUtil
    }
    object TestConverter {
        fun postConverter() = PostConverter
    }

}