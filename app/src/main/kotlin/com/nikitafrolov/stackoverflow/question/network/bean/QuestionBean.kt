package com.nikitafrolov.stackoverflow.question.network.bean

import com.fasterxml.jackson.annotation.JsonProperty

data class QuestionBean(
    @JsonProperty("question_id")
    val id: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("body")
    val body: String,
    @JsonProperty("owner")
    val owner: UserBean
)