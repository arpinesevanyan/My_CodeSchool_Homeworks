package com.example.mycodeschoolhomeworks.recyclerview.data

import com.example.mycodeschoolhomeworks.recyclerview.data.model.CountryEnum
import com.example.mycodeschoolhomeworks.recyclerview.data.model.PostTypeEnum

data class Post(val enum: PostTypeEnum){
    private val items = PostTypeEnum.values()

}
