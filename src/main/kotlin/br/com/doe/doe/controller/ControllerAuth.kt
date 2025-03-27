package br.com.doe.doe.controller

import br.com.doe.doe.dto.NewUserForm
import br.com.doe.doe.dto.UserView
import br.com.doe.doe.service.ServiceAuth
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class ControllerAuth(private val service: ServiceAuth) {

    @GetMapping
    fun listar(): List<UserView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): UserView {
        return service.getById(id)
    }

    @PostMapping
    fun setUser(@RequestBody @Valid dto: NewUserForm) {
        service.setUser(dto)
    }
}