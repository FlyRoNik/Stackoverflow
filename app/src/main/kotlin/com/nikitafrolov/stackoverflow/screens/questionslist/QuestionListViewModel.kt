package com.nikitafrolov.stackoverflow.screens.questionslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nikitafrolov.stackoverflow.question.FetchQuestionListUseCase
import com.nikitafrolov.stackoverflow.question.Question
import com.nikitafrolov.stackoverflow.screens.common.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QuestionListViewModel(
    private val fetchQuestionListUseCase: FetchQuestionListUseCase
) : BaseViewModel() {

    private val questionsLD: MutableLiveData<List<Question>> = MutableLiveData()
    private val errorLD: MutableLiveData<Throwable> = MutableLiveData()

    fun getQuestionsLD(): LiveData<List<Question>> = questionsLD
    fun getErrorLD(): LiveData<Throwable> = errorLD

    fun fetchQuestion(pageLimit: Int) =
        fetchQuestionListUseCase.fetchLastActiveQuestions(pageLimit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                questionsLD.value = it
            }, {
                errorLD.value = it
            }).addSubscription()
}