package com.taylorm.s169382.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/*
Abstract class for a Flow use case.
 */

abstract class FlowUseCase<in Param, Result>(private val coroutineDispatcher: CoroutineDispatcher) {

    /*
    Executes the use case with the specified parameters and return a Flow of the result.
    The Flow is executed on the CoroutineDispatcher specified in the constructor.
     */
    operator fun invoke(parameters: Param): Flow<Result> = execute(parameters)
        .flowOn(coroutineDispatcher)

    /*
    Abstract method implemented by subclasses.
    Represent the actual use case implementation.
     */
    protected abstract fun execute(parameters: Param): Flow<Result>
}