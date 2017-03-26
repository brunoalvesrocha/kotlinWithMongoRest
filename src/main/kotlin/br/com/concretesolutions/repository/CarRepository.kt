package br.com.concretesolutions.repository

import br.com.concretesolutions.model.Car
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.util.stream.Stream

/**
 * Created by brunorocha on 3/25/17.
 */
interface CarRepository : MongoRepository<Car, String> {

    @Query("{}")
    fun all(): Stream<Car>

    fun findByBrand(brand: String): List<Car>

    fun findByModel(model: String): List<Car>
}