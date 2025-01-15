package edu.danialmkj.myrecipeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.danialmkj.myrecipeapplication.ui.theme.MyRecipeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MyRecipeApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
//                    RecipeScreen()
                    RecipeApp(navController = navController)
                }
            }
        }
    }
}