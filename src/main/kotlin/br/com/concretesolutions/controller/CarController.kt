package br.com.concretesolutions.controller

import br.com.concretesolutions.model.Car
import br.com.concretesolutions.repository.CarRepository
import org.springframework.http.MediaType
import org.springframework.http.MediaType.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMethod.*

/**
 * Created by brunorocha on 3/25/17.
 */

@RestController
open class CarController(var carRepository: CarRepository) {

    @GetMapping("/", consumes = arrayOf(APPLICATION_JSON_VALUE))
    private fun findAll() = carRepository.findAll()

    @PostMapping("/brand", consumes = arrayOf(APPLICATION_JSON_VALUE))
    private fun findByBrand(@RequestBody car: Car): List<Car>{
        val brand = car.brand.toString()
        return carRepository.findByBrand(brand)
    }

    @PostMapping("/model", consumes = arrayOf(APPLICATION_JSON_VALUE))
    private fun findByModel(@RequestBody car: Car): List<Car> {
        val model = car.model.toString()
        return carRepository.findByModel(model)
    }
}