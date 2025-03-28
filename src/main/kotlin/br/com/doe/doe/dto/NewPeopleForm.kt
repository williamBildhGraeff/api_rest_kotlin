package br.com.doe.doe.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewPeopleForm (
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 2, max = 3, message = "Nome deve ser menor que dois caracteres") val name: String,
    @field:NotEmpty(message = "Não pode estar vazio") val document: String
)
