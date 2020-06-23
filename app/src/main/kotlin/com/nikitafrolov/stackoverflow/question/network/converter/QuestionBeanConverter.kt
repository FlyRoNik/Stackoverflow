package com.nikitafrolov.stackoverflow.question.network.converter

import com.nikitafrolov.stackoverflow.common.converter.BaseInConverter
import com.nikitafrolov.stackoverflow.question.network.bean.QuestionBean
import com.nikitafrolov.stackoverflow.question.Question

class QuestionBeanConverter : BaseInConverter<QuestionBean, Question>() {

    override fun processConvertInToOut(inObject: QuestionBean?): Question? = inObject?.run {
        Question(id, title, body, owner.name, owner.avatar)
    }
}