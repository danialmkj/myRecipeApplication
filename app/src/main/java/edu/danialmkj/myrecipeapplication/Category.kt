package edu.danialmkj.myrecipeapplication

//create category data class
data class Category(
    var idCategory: String,
    var strCategory: String,
    var strCategoryThumb: String,
    var strCategoryDescription: String
)


//create list of category class
data class CategoriesResponse(var categories: List<Category>)
