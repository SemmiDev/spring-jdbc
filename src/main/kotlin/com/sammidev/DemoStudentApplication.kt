package com.sammidev

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoStudentApplication

fun main(args: Array<String>) {
	runApplication<DemoStudentApplication>(*args)
}
