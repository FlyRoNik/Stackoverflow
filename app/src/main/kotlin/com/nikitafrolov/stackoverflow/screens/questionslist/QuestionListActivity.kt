package com.nikitafrolov.stackoverflow.screens.questionslist

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nikitafrolov.stackoverflow.question.Question
import com.nikitafrolov.stackoverflow.screens.common.activity.BaseActivity
import com.nikitafrolov.stackoverflow.screens.common.mvcview.ViewMvcFactory
import com.nikitafrolov.stackoverflow.screens.common.viewmodel.ViewModelFactory
import javax.inject.Inject

class QuestionListActivity : BaseActivity(),
    QuestionListViewMvc.Listener {

    companion object {
        private const val NUM_OF_QUESTIONS_TO_FETCH = 40
    }

    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewMvc: QuestionListViewMvc
    private lateinit var viewModel: QuestionListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresentationComponent().inject(this)
        viewMvc = viewMvcFactory.newInstance(QuestionListViewMvc::class.java, null)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(QuestionListViewModel::class.java)
        setContentView(viewMvc.rootView)

        viewModel.run {
            getQuestionsLD().observe(this@QuestionListActivity, Observer {
                viewMvc.bindQuestions(it)
            })
            getErrorLD().observe(this@QuestionListActivity, Observer {
                Toast.makeText(this@QuestionListActivity, it.message, Toast.LENGTH_SHORT)
                    .show()
            })
        }
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        viewModel.fetchQuestion(NUM_OF_QUESTIONS_TO_FETCH)
    }

    override fun onStop() {
        viewMvc.unregisterListener(this)
        super.onStop()
    }

    override fun onQuestionClicked(question: Question) {
        //TODO show detail screen
        Toast.makeText(this, "show detail screen", Toast.LENGTH_SHORT).show()
    }
}
