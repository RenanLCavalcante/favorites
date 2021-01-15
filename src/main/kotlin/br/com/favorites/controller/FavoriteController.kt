package br.com.favorites.controller

import br.com.favorites.model.Favorite
import br.com.favorites.repository.FavoriteRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("/favorites")
class FavoriteController(
    private val favoriteRepository: FavoriteRepository
) {

    @PostMapping
    fun create(favorite: Favorite): ModelAndView {
        favoriteRepository.save(favorite)
        val modelAndView = ModelAndView("/index")
        modelAndView.addObject("listOfFavorites", favoriteRepository.findAll())
        return modelAndView
    }

    @PostMapping("/delete")
    fun delete(id: String): ModelAndView {
        favoriteRepository.deleteById(id);
        val modelAndView = ModelAndView("/index")
        modelAndView.addObject("listOfFavorites", favoriteRepository.findAll())
        return modelAndView
    }

    @GetMapping("/create")
    fun formCreate(): ModelAndView {
        return ModelAndView("/create")
    }

    @GetMapping
    fun getAll(): ModelAndView {
        val modelAndView = ModelAndView("/index")
        modelAndView.addObject("listOfFavorites", favoriteRepository.findAll())
        return modelAndView
    }
}