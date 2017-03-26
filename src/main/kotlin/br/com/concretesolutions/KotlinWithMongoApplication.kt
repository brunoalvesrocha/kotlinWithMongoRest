package br.com.concretesolutions

import br.com.concretesolutions.model.Car
import br.com.concretesolutions.repository.CarRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.util.stream.Stream

@SpringBootApplication
open class KotlinWithMongoApplication{

    @Bean
    open fun init(carRepository: CarRepository) = CommandLineRunner{

        carRepository.deleteAll();

        Stream.of("VW,Golf", "VW,Touareg", "VW,Fusca",
                "Audi,A3", "Audi,A4", "Audi,A8",
                "Mercedes,GT", "Mercedes,A45", "Mercedes,E63")
                .map { fn -> fn.split(",") }
                .forEach { car -> carRepository.save(Car(car[0], car[1])) }

        carRepository.all().forEach { println(it) }
//    carRepository.all().forEach(::println)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinWithMongoApplication::class.java, *args)
}
