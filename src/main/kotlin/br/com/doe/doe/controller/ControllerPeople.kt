package br.com.doe.doe.controller

import br.com.doe.doe.dto.AtualizacaoPeopleForm
import br.com.doe.doe.dto.NewPeopleForm
import br.com.doe.doe.dto.PeopleView
import br.com.doe.doe.model.People
import br.com.doe.doe.service.ServicePeople
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/people")
class ControllerPeople(private val service: ServicePeople) {

    @GetMapping
    fun list(): List<People>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): People{
        return service.getById(id)
    }

    @PostMapping
    fun setPeople(@RequestBody people: NewPeopleForm, uriBuilder: UriComponentsBuilder ): ResponseEntity<PeopleView>{
        val peopleView = service.setPeople(people)
        val uri = uriBuilder.path("/people/${peopleView.id}").build().toUri()
        return ResponseEntity.created(uri).body(peopleView)
    }

    @PutMapping
    fun update(@RequestBody @Valid people: AtualizacaoPeopleForm): ResponseEntity<PeopleView>{
        val peopleView = service.update(people)
        return ResponseEntity.ok(peopleView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }

}