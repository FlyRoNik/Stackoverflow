package com.nikitafrolov.stackoverflow.question

import com.nikitafrolov.stackoverflow.common.converter.Converter
import com.nikitafrolov.stackoverflow.question.network.StackoverflowApi
import com.nikitafrolov.stackoverflow.question.network.bean.QuestionBean
import io.reactivex.Single

class FetchQuestionListUseCase(
    private val api: StackoverflowApi,
    private val converter: Converter<QuestionBean, Question>
) {

    fun fetchLastActiveQuestions(pageLimit: Int): Single<List<Question>> =
        api.lastActiveQuestions(pageLimit)
            .map { it.questions }
            .compose(converter.single.listInToOut())
}