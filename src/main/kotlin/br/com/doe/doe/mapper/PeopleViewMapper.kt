package br.com.doe.doe.mapper

import br.com.doe.doe.dto.PeopleView
import br.com.doe.doe.dto.UserView
import br.com.doe.doe.model.People
import br.com.doe.doe.model.User
import org.springframework.stereotype.Component

@Component
class PeopleViewMapper: Mapper<People, PeopleView> {
    override fun map(p: People): PeopleView {
        return PeopleView(
            p.id, p.document, p.name
        )
    }
}