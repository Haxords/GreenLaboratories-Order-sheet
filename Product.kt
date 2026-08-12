package com.greenlaboratories.ordersheet

data class Product(
    val id: String,
    val name: String,
    val category: String,
    val price: Double,
    var quantity: Int = 0
)

object SampleData {
    val productList = listOf(
        Product(id = "1", name = "Artasin 500mg", category = "Osteoarthritis", price = 15.0),
        Product(id = "2", name = "Dietin 5mg", category = "Diabetes Management", price = 10.0),
        Product(id = "3", name = "Paracetamol 500mg", category = "General", price = 2.5)
    )
}
