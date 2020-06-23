package com.nikitafrolov.stackoverflow.question.network.bean

import com.fasterxml.jackson.annotation.JsonProperty

data class UserBean(
    @JsonProperty("display_name")
    val name: String,
    @JsonProperty("profile_image")
    val avatar: String
)