package br.com.favorites.model

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Favorite(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String?,
    val link: String
)