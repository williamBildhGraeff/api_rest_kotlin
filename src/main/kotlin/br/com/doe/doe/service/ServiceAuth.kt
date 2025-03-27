package br.com.doe.doe.service

import br.com.doe.doe.dto.NewUserForm
import br.com.doe.doe.dto.UserView
import br.com.doe.doe.mapper.UserFormMapper
import br.com.doe.doe.mapper.UserViewMapper
import br.com.doe.doe.model.User
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.stream.Collectors

@Service
class ServiceAuth(
    private var usurious: List<User> = ArrayList(),
    private val userViewMapper: UserViewMapper,
    private val userFormMapper: UserFormMapper
) {

    fun list(): List<UserView> {
        return usurious.stream().map { u -> userViewMapper.map(u) }.collect(Collectors.toList())
    }

    fun getById(id: Long): UserView{
        val usuario = usurious.stream().filter { user ->
            user.id == id
        }.findFirst().get()

        return userViewMapper.map(usuario)
    }

    fun setUser(@RequestBody form: NewUserForm) {

        val user = userFormMapper.map(form)
        usurious = usurious + user
    }
}