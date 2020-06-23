package com.nikitafrolov.stackoverflow.question.network.bean

import com.fasterxml.jackson.annotation.JsonProperty

data class QuestionListBean(
    @JsonProperty("items")
    val questions: List<QuestionBean>
)