package br.com.doe.doe.mapper

interface Mapper<U, Uv> {
    fun map(u: U): Uv
}