package br.com.doe.doe.mapper

import br.com.doe.doe.dto.NewUserForm
import br.com.doe.doe.model.User
import br.com.doe.doe.service.ServicePeople
import org.springframework.stereotype.Component

@Component
class UserFormMapper(private val servicePeople: ServicePeople): Mapper<NewUserForm, User> {
    override fun map(u: NewUserForm): User {
        return User(
            id = u.id,
            name = u.name,
            email = u.email,
            people = servicePeople.getById(u.peopleId)
        )
    }

}
