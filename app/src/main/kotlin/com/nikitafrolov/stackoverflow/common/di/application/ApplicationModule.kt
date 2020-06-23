package com.nikitafrolov.stackoverflow.common.di.application

import android.app.Application
import com.nikitafrolov.stackoverflow.question.FetchQuestionListUseCase
import com.nikitafrolov.stackoverflow.question.network.StackoverflowApi
import com.nikitafrolov.stackoverflow.question.network.converter.QuestionBeanConverter
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun getFetchQuestionListUseCase(
        api: StackoverflowApi
    ): FetchQuestionListUseCase = FetchQuestionListUseCase(api, QuestionBeanConverter())
}