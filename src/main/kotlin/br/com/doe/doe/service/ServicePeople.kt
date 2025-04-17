package br.com.doe.doe.service

import br.com.doe.doe.dto.AtualizacaoPeopleForm
import br.com.doe.doe.dto.NewPeopleForm
import br.com.doe.doe.dto.PeopleView
import br.com.doe.doe.exception.NotFoundException
import br.com.doe.doe.mapper.PeopleFormMapper
import br.com.doe.doe.mapper.PeopleViewMapper
import br.com.doe.doe.model.People
import br.com.doe.doe.repository.PeopleRepository
import jakarta.validation.Valid
import org.hibernate.annotations.NotFound
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service

class ServicePeople(
    private val repository: PeopleRepository,
    private var peopleFormMapper: PeopleFormMapper,
    private var peopleViewMapper: PeopleViewMapper,
    private val notFoundMessage: String = "Pessoa não encontrada!"
) {

    fun list(): List<PeopleView> {
        return repository.findAll().stream().map{ p -> peopleViewMapper.map(p)}.collect(Collectors.toList())
    }

    fun getById(id: Long): People {
        return repository.getOne(id)
    }

    fun setPeople(@Valid people: NewPeopleForm): PeopleView{
        val newPeople = peopleFormMapper.map(people)
        repository.save(newPeople)
        return peopleViewMapper.map(newPeople)
    }

    fun update(form: AtualizacaoPeopleForm): PeopleView{
        val people = repository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }
        people.name = form.name
        people.document = form.document

        return peopleViewMapper.map(people)
    }

    fun delete(id: Long) {
       repository.deleteById(id)
    }


}