package br.com.doe.doe.repository

import br.com.doe.doe.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>{
}