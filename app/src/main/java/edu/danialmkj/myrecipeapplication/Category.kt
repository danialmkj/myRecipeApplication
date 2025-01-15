package edu.danialmkj.myrecipeapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//create category data class
//by adding @Parcelize (at first) & Parcelable(at the End of Object) keywords we can [[serialize]] and [[deserialize]] our {Object}
@Parcelize
data class Category(
    var idCategory: String,
    var strCategory: String,
    var strCategoryThumb: String,
    var strCategoryDescription: String
) : Parcelable


//create list of category class
data class CategoriesResponse(var categories: List<Category>)
