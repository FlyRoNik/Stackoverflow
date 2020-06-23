package com.nikitafrolov.stackoverflow.question.network

import com.nikitafrolov.stackoverflow.question.network.bean.QuestionBean
import com.nikitafrolov.stackoverflow.question.network.bean.QuestionListBean
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StackoverflowApi {

    @GET("/questions?order=desc&sort=activity&site=stackoverflow&filter=withbody")
    fun lastActiveQuestions(@Query("pagesize") pageSize: Int): Single<QuestionListBean>

    @GET("/questions/{questionId}?site=stackoverflow&filter=withbody")
    fun questionDetails(@Path("questionId") questionId: String): Single<QuestionBean>
}