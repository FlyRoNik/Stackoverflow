package com.nikitafrolov.stackoverflow.screens.questionslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikitafrolov.stackoverflow.R
import com.nikitafrolov.stackoverflow.question.Question
import com.nikitafrolov.stackoverflow.screens.common.list.BaseRecyclerViewAdapter
import com.nikitafrolov.stackoverflow.screens.common.list.BaseViewHolder
import kotlinx.android.synthetic.main.item_question.view.*
import java.lang.ref.WeakReference

interface QuestionAdapterListener {

    fun onClickItem(item: Question)
}

class QuestionAdapter(
    listener: QuestionAdapterListener
) : BaseRecyclerViewAdapter<Question, QuestionAdapter.QuestionVH>(),
    QuestionAdapterListener {

    private var listenerWR = WeakReference(listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionVH =
        QuestionVH.newInstance(
            parent,
            this
        )

    override fun onBindViewHolder(holder: QuestionVH, position: Int) =
        holder.bind(getItem(position))

    override fun onClickItem(item: Question) {
        listenerWR.get()?.onClickItem(item)
    }

    class QuestionVH private constructor(
        view: View,
        private val listener: QuestionAdapterListener
    ) : BaseViewHolder<Question>(view) {

        companion object {
            fun newInstance(
                parent: ViewGroup,
                listener: QuestionAdapterListener
            ) =
                QuestionVH(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_question, parent, false),
                    listener
                )
        }

        override fun bind(item: Question) {
            itemView.run {
                tvTitle.text = item.title
                setOnClickListener { listener.onClickItem(item) }
            }
        }
    }
}