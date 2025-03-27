package br.com.doe.doe.service

import br.com.doe.doe.dto.AtualizacaoPeopleForm
import br.com.doe.doe.dto.NewPeopleForm
import br.com.doe.doe.dto.PeopleView
import br.com.doe.doe.mapper.PeopleFormMapper
import br.com.doe.doe.mapper.PeopleViewMapper
import br.com.doe.doe.model.People
import org.springframework.stereotype.Service

@Service

class ServicePeople(
    private var peoples: List<People> = ArrayList(),
    private var peopleFormMapper: PeopleFormMapper,
    private var peopleViewMapper: PeopleViewMapper
) {

    fun list(): List<People> {
        return peoples
    }

    fun getById(id: Long): People {
        return peoples.stream().filter({
            p -> p.id == id
        }).findFirst().get()
    }

    fun setPeople(people: NewPeopleForm): PeopleView{
        val newPeople = peopleFormMapper.map(people)
        newPeople.id = peoples.size.toLong() + 1
        peoples = peoples + newPeople
        return peopleViewMapper.map(newPeople)
    }

    fun update(form: AtualizacaoPeopleForm): PeopleView{
        val oldPeople = this.getById(form.id)

        peoples = peoples.minus(oldPeople).plus(People(
            id = form.id,
            name = form.name,
            document = form.document
        ))
        val updatePeople = this.getById(form.id)
        return peopleViewMapper.map(updatePeople)
    }

    fun delete(id: Long) {
        val deletePeople = this.getById(id)
        peoples = peoples.minus(deletePeople)
    }


}