package br.com.doe.doe.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class AtualizacaoPeopleForm (
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 2) val name: String,
    @field:NotEmpty val document: String
)