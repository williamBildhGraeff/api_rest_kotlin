package br.com.doe.doe.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.Date

data class NewPeopleForm (
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 2, max = 3, message = "Nome deve ser maior que dois caracteres") val name: String,
    @field:NotEmpty(message = "Não pode estar vazio") val document: String,
    val birth_date: Date
)
