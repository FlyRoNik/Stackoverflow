package com.nikitafrolov.stackoverflow.common.converter

import io.reactivex.SingleTransformer
import java.lang.ref.WeakReference

class SingleConverter<IN, OUT>(converter: Converter<IN, OUT>) {

    private val converterWR = WeakReference(converter)

    fun inToOut(): SingleTransformer<IN, OUT> = SingleTransformer { IN ->
        IN.map { converterWR.get()?.inToOut(it) }
    }

    fun outToIn(): SingleTransformer<OUT, IN> = SingleTransformer { OUT ->
        OUT.map { converterWR.get()?.outToIn(it) }
    }

    fun listInToOut(): SingleTransformer<List<IN>, List<OUT>> = SingleTransformer { IN ->
        IN.map { converterWR.get()?.listInToOut(it) }
    }

    fun listOutToIn(): SingleTransformer<List<OUT>, List<IN>> = SingleTransformer { OUT ->
        OUT.map { converterWR.get()?.listOutToIn(it) }
    }
}