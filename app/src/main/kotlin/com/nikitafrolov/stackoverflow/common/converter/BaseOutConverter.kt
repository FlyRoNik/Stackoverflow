package com.nikitafrolov.stackoverflow.common.converter

abstract class BaseOutConverter<IN : Any, OUT : Any> : BaseConverter<IN, OUT>() {

    override fun processConvertInToOut(inObject: IN?): OUT? = null

}