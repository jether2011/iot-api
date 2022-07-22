package br.com.i3focus.domain

interface Mapper<I, O> {
    fun map(input: I): O
}