package com.nikitafrolov.stackoverflow.question

import com.nikitafrolov.stackoverflow.common.converter.Converter
import com.nikitafrolov.stackoverflow.question.network.StackoverflowApi
import com.nikitafrolov.stackoverflow.question.network.bean.QuestionBean
import io.reactivex.Single

class FetchQuestionUseCase(
    private val api: StackoverflowApi,
    private val converter: Converter<QuestionBean, Question>
) {

    fun fetchQuestion(id: String): Single<Question> =
        api.questionDetails(id)
            .compose(converter.single.inToOut())
}