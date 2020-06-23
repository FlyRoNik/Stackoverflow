package com.nikitafrolov.stackoverflow.common.converter

import io.reactivex.FlowableTransformer
import java.lang.ref.WeakReference

class FlowableConverter<IN, OUT>(converter: Converter<IN, OUT>) {

    private val converterWR = WeakReference(converter)

    fun inToOut(): FlowableTransformer<IN?, OUT> = FlowableTransformer { IN ->
        IN.map { converterWR.get()?.inToOut(it) }
    }

    fun outToIn(): FlowableTransformer<OUT?, IN> = FlowableTransformer { OUT ->
        OUT.map { converterWR.get()?.outToIn(it) }
    }

    fun listInToOut(): FlowableTransformer<List<IN>, List<OUT>> = FlowableTransformer { IN ->
        IN.map { converterWR.get()?.listInToOut(it) }
    }

    fun listOutToIn(): FlowableTransformer<List<OUT>, List<IN>> = FlowableTransformer { OUT ->
        OUT.map { converterWR.get()?.listOutToIn(it) }
    }
}