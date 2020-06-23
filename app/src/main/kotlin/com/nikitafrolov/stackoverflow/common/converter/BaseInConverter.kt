package com.nikitafrolov.stackoverflow.common.converter

abstract class BaseInConverter<IN : Any, OUT : Any> : BaseConverter<IN, OUT>() {

    override fun processConvertOutToIn(outObject: OUT?): IN? = null

}