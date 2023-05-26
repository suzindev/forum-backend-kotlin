package br.com.suzintech.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}