package br.com.doe.doe.service

import br.com.doe.doe.dto.NewUserForm
import br.com.doe.doe.dto.UserView
import br.com.doe.doe.mapper.UserFormMapper
import br.com.doe.doe.mapper.UserViewMapper
import br.com.doe.doe.model.User
import br.com.doe.doe.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.stream.Collectors

@Service
class ServiceAuth(
    private val repository: UserRepository,
    private val userViewMapper: UserViewMapper,
    private val userFormMapper: UserFormMapper
) {

    fun list(): List<UserView> {
        return repository.findAll().stream().map { u -> userViewMapper.map(u) }.collect(Collectors.toList())
    }

    fun getById(id: Long): UserView{
        return userViewMapper.map(repository.getById(id))
    }

    fun setUser(@RequestBody form: NewUserForm): UserView {
        val user = userFormMapper.map(form)
        repository.save(user)
        return userViewMapper.map(user)
    }
}