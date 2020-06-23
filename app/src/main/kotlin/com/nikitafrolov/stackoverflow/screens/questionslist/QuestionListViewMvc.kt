package com.nikitafrolov.stackoverflow.screens.questionslist

import com.nikitafrolov.stackoverflow.question.Question
import com.nikitafrolov.stackoverflow.screens.common.mvcview.ObservableViewMvc

interface QuestionListViewMvc : ObservableViewMvc<QuestionListViewMvc.Listener> {

    interface Listener {
        fun onQuestionClicked(question: Question)
    }

    fun bindQuestions(questions: List<Question>)
}