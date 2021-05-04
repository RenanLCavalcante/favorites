package br.com.favorites.controller

import br.com.favorites.model.Favorite
import br.com.favorites.repository.FavoriteRepository
import org.slf4j.LoggerFactory
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("/favorites")
class FavoriteController(
    private val favoriteRepository: FavoriteRepository
) {

    private val logger = LoggerFactory.getLogger(FavoriteController::class.java)

    @PostMapping
    fun create(favorite: Favorite): ModelAndView {
        logger.debug("creating, favorite:{}", favorite)
        favoriteRepository.save(favorite)
        val modelAndView = ModelAndView("index")
        modelAndView.addObject("listOfFavorites", getAllFavorites())
        return modelAndView
    }

    @PostMapping("/update")
    fun update(favorite: Favorite): ModelAndView {
        logger.debug("updating, favorite:{}", favorite)
        favoriteRepository.save(favorite)
        val modelAndView = ModelAndView("redirect:/favorites")
        modelAndView.addObject("listOfFavorites", getAllFavorites())
        return modelAndView
    }

    @PostMapping("/delete")
    fun delete(id: String): ModelAndView {
        logger.debug("deleting, id:{}", id)
        favoriteRepository.deleteById(id)
        val modelAndView = ModelAndView("redirect:/favorites")
        modelAndView.addObject("listOfFavorites", getAllFavorites())
        return modelAndView
    }

    @GetMapping("/create")
    fun formCreate(): ModelAndView {
        return ModelAndView("create")
    }

    @GetMapping("/update/{id}")
    fun formUpdate(@PathVariable id: String): ModelAndView {
        val favorite = favoriteRepository.findById(id).orElseThrow { Exception("Not found favorite by id:$id") }
        val modelAndView = ModelAndView("update")
        modelAndView.addObject("favorite", favorite)
        return modelAndView
    }

    @GetMapping
    fun getAll(): ModelAndView {
        val modelAndView = ModelAndView("index")
        modelAndView.addObject("listOfFavorites", getAllFavorites())
        return modelAndView
    }

    private fun getAllFavorites(): List<Favorite> {
        return favoriteRepository.findAllByOrderByName()
    }
}