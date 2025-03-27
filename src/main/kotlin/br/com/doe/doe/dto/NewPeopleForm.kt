package br.com.doe.doe.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class NewPeopleForm (
    @field:NotNull val id: Long,
    @field:NotEmpty val name: String,
    @field:NotEmpty val document: String
)
