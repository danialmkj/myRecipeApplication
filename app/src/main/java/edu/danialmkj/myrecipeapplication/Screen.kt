package edu.danialmkj.myrecipeapplication

//to access my route inside of composable which take care of navigation we use sealed classes
sealed class Screen(val route: String) {
    object RecipeScreen : Screen("recipescreen")
    object Detailscreen : Screen("detailscreen")
}