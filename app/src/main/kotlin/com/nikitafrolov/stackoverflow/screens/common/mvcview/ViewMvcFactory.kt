package com.nikitafrolov.stackoverflow.screens.common.mvcview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nikitafrolov.stackoverflow.screens.questionslist.QuestionListViewMvc
import com.nikitafrolov.stackoverflow.screens.questionslist.QuestionListViewMvcImpl
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(private val layoutInflater: LayoutInflater) {

    /**
     * Instantiate a new implementation of MVC view. The returned instance will be casted to MVC view
     * type inferred by java's automatic type inference.
     * @param mvcViewClass the class of the required MVC view
     * @param container this container will be used as MVC view's parent. See [LayoutInflater.inflate]
     * @param <T> the type of the required MVC view
     * @return new instance of MVC view
    </T> */
    fun <T : ViewMvc> newInstance(mvcViewClass: Class<T>, container: ViewGroup?): T =
        when (mvcViewClass) {
            QuestionListViewMvc::class.java -> QuestionListViewMvcImpl(layoutInflater, container)
            else -> throw IllegalArgumentException("unsupported MVC view class $mvcViewClass")
        } as T
}