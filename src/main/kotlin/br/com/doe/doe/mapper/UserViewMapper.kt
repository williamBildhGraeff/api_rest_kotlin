package br.com.doe.doe.mapper

import br.com.doe.doe.dto.UserView
import br.com.doe.doe.model.User
import org.springframework.stereotype.Component

@Component
class UserViewMapper: Mapper<User, UserView> {
    override fun map(u: User): UserView {
        return UserView(
            u.id, u.name
        )
    }
}