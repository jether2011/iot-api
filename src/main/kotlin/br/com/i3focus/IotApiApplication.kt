package br.com.i3focus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IotApiApplication

fun main(args: Array<String>) {
	runApplication<IotApiApplication>(*args)
}
