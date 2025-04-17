package br.com.doe.doe.repository

import br.com.doe.doe.model.People
import org.springframework.data.jpa.repository.JpaRepository

interface PeopleRepository: JpaRepository<People, Long> {

}