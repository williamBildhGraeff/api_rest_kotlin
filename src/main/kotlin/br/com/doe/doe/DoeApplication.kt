package br.com.doe.doe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DoeApplication

fun main(args: Array<String>) {
	runApplication<DoeApplication>(*args)
}
