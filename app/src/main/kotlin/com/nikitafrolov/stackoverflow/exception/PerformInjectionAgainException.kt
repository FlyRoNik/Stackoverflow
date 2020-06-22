package com.nikitafrolov.stackoverflow.exception

class PerformInjectionAgainException :
    RuntimeException("There is no reason to perform injection more than once")