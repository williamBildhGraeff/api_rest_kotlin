package br.com.doe.doe.mapper

import br.com.doe.doe.dto.NewPeopleForm
import br.com.doe.doe.dto.NewUserForm
import br.com.doe.doe.model.People
import br.com.doe.doe.model.User
import br.com.doe.doe.service.ServicePeople
import org.springframework.stereotype.Component

@Component
class PeopleFormMapper(): Mapper<NewPeopleForm, People> {
    override fun map(u: NewPeopleForm): People {
        return People(
            id = u.id,
            name = u.name,
            document = u.document,
        )
    }

}
