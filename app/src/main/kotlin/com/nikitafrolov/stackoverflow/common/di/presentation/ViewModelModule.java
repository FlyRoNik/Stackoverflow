package com.nikitafrolov.stackoverflow.common.di.presentation;

import androidx.lifecycle.ViewModel;

import com.nikitafrolov.stackoverflow.question.FetchQuestionListUseCase;
import com.nikitafrolov.stackoverflow.screens.common.viewmodel.ViewModelFactory;
import com.nikitafrolov.stackoverflow.screens.questionslist.QuestionListViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class ViewModelModule {

    @Provides
    ViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new ViewModelFactory(providerMap);
    }

    @Provides
    @IntoMap
    @ViewModelKey(QuestionListViewModel.class)
    ViewModel questionsListViewModel(FetchQuestionListUseCase fetchQuestionListUseCase) {
        return new QuestionListViewModel(fetchQuestionListUseCase);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }
}
