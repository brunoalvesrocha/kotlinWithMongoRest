package br.com.concretesolutions.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by brunorocha on 3/25/17.
 */

@Document
data class Car(var brand: String? = null,
             var model: String? = null,
             @Id var id: String? =null)