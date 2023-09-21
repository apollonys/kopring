package com.ys.project

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class ProjectApplication

fun main(args: Array<String>) {
	runApplication<ProjectApplication>(*args)
}
