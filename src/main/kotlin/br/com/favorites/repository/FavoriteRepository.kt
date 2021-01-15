package br.com.favorites.repository

import br.com.favorites.model.Favorite
import org.springframework.data.mongodb.repository.MongoRepository

interface FavoriteRepository: MongoRepository<Favorite, String> {
    fun findAllByOrderByName(): List<Favorite>
}