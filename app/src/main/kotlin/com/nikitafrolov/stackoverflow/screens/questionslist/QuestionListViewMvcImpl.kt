package com.nikitafrolov.stackoverflow.screens.questionslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikitafrolov.stackoverflow.R
import com.nikitafrolov.stackoverflow.question.Question
import com.nikitafrolov.stackoverflow.screens.common.list.SimpleItemDecorator
import com.nikitafrolov.stackoverflow.screens.common.mvcview.BaseViewMvc
import kotlinx.android.synthetic.main.question_list.view.*

class QuestionListViewMvcImpl(
    inflater: LayoutInflater,
    container: ViewGroup?
) : BaseViewMvc<QuestionListViewMvc.Listener>(),
    QuestionListViewMvc,
    QuestionAdapterListener {

    private var questionAdapter: QuestionAdapter? = null
        get() = field ?: QuestionAdapter(this).apply { field = this }

    init {
        rootView = inflater.inflate(R.layout.question_list, container, false)
        rootView.rvQuestion.run {
            layoutManager = LinearLayoutManager(this@QuestionListViewMvcImpl.context)
            adapter = questionAdapter
            addItemDecoration(
                SimpleItemDecorator(
                    context.resources,
                    R.dimen.question_item_left_offset,
                    R.dimen.question_item_right_offset,
                    R.dimen.question_item_top_offset,
                    R.dimen.question_item_bottom_offset,
                    R.dimen.question_item_top_offset,
                    R.dimen.question_item_bottom_offset
                )
            )
        }
    }

    override fun bindQuestions(questions: List<Question>) {
        questionAdapter?.updateAllNotify(questions)
    }

    override fun onClickItem(item: Question) {
        getListeners().forEach { it.onQuestionClicked(item) }
    }
}