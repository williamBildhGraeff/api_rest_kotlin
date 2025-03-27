package br.com.doe.doe.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewUserForm(
    val id: Long,
    @field:NotEmpty @field:Size(min = 2) val name: String,
    @field:NotNull val email: String,
    @field:NotNull val peopleId: Long)