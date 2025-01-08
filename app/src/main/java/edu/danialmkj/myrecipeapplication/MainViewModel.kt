package edu.danialmkj.myrecipeapplication

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//this mean MainViewModel is type of ViewModel(we are connecting data layer to domain(Logic) layer)
class MainViewModel : ViewModel() {

    //create private an public variables when states changes in the ui
    private val _categoriesState = mutableStateOf(RecipeState()) //enable changing the ui
    val categoriesState: State<RecipeState> =
        _categoriesState //expose that state to external classes like MainActivity or composable which going to care all of User Interface

    //initial state
    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        //run this coroutine(allow us to call functions which return suspend functions (functions which don't happen synchronously but happen asynchronously. they happen in background))
        viewModelScope.launch {
            try {
                //fetch Response
                val response = recipeService.getCategories()
                //fill data state from response
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            } catch (e: Exception) {
                _categoriesState.value.copy(
                    loading = false,
                    error = "Error occurred fetching categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    ) {}
}