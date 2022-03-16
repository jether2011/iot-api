package br.com.i3focus.domain

interface Mapper<I, O> {
    fun toEntity(input: I): O

    fun toDto(input: O): I
}