package com.nikitafrolov.stackoverflow.common.converter

import androidx.annotation.Nullable

/**
 * Encapsulate logic for converting from one type to another and vice versa
 *
 * @param <IN>  Input type
 * @param <OUT> Output type
 *
 */

interface Converter<IN, OUT> {

    val observable: ObservableConverter<IN, OUT>
    val single: SingleConverter<IN, OUT>
    val flowable: FlowableConverter<IN, OUT>

    /**
     * Convert IN to OUT
     *
     * @param inObject object ot inToOut
     * @return Nullable [OUT] converted object
     */
    fun inToOut(@Nullable inObject: IN?): OUT?

    /**
     * Convert OUT to IN
     *
     * @param outObject [OUT] object ot outToIn
     * @return Nullable [IN] Converted object
     */
    @Nullable
    fun outToIn(@Nullable outObject: OUT?): IN?

    /**
     * Convert List of IN to List of OUT
     *
     * @param inObjects [List] of [IN] objects to listInToOut
     * @return [List] of converted objects
     */
    @Nullable
    fun listInToOut(@Nullable inObjects: List<IN>?): List<OUT>

    /**
     * Convert List of OUT to List of IN
     *
     * @param outObjects [List] of [OUT] objects to listOutToIn
     * @return [List] of converted objects
     */
    @Nullable
    fun listOutToIn(@Nullable outObjects: List<OUT>?): List<IN>
}