package com.nikitafrolov.stackoverflow.common.converter

import io.reactivex.ObservableTransformer
import java.lang.ref.WeakReference

class ObservableConverter<IN, OUT>(converter: Converter<IN, OUT>) {

    private val converterWR = WeakReference(converter)

    fun inToOut(): ObservableTransformer<IN, OUT> = ObservableTransformer { IN ->
        IN.map { converterWR.get()?.inToOut(it) }
    }

    fun outToIn(): ObservableTransformer<OUT, IN> = ObservableTransformer { OUT ->
        OUT.map { converterWR.get()?.outToIn(it) }
    }

    fun listInToOut(): ObservableTransformer<List<IN>, List<OUT>> = ObservableTransformer { IN ->
        IN.map { converterWR.get()?.listInToOut(it) }
    }

    fun listOutToIn(): ObservableTransformer<List<OUT>, List<IN>> = ObservableTransformer { OUT ->
        OUT.map { converterWR.get()?.listOutToIn(it) }
    }
}