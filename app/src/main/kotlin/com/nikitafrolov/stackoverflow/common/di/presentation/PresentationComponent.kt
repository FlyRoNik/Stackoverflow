package com.nikitafrolov.stackoverflow.common.di.presentation

import com.nikitafrolov.stackoverflow.screens.questionslist.QuestionListActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresentationModule::class, ViewModelModule::class])
interface PresentationComponent {
    fun inject(questionsListActivity: QuestionListActivity)
}