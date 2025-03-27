package br.com.doe.doe.model

import java.time.LocalDateTime

data class User(val id: Long, val name: String, val email: String, val people: People)