package br.com.favorites

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FavoritesApplication

fun main(args: Array<String>) {
	runApplication<FavoritesApplication>(*args)
}
