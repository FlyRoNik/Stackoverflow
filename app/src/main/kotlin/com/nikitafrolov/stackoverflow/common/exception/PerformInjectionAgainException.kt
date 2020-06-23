package com.nikitafrolov.stackoverflow.common.exception

class PerformInjectionAgainException :
    RuntimeException("There is no reason to perform injection more than once")