package com.example.lab1_part2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1_part2.ui.theme.Lab1_Part2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1_Part2Theme {
                RecipeApp()
            }
        }
    }
}

@Composable
fun RecipeApp() {
    // State variable to show/hide the recipe
    var isRecipeVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4B5)) // Light non-black, non-white background color
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Title Text (larger size, different color)


        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "Phoenix Image",
            modifier = Modifier.size(40.dp)  // Size of the image
        )

        Spacer(modifier = Modifier.width(16.dp))  // Add space between image and text

        // Center the heading text
        Text(
            text = "Receipe App",

            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        // Row 1: Text on the left, Image on the right
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Recipe text on the left
            if (isRecipeVisible) {
                Text(
                    text = """
                        Ingredients:
                        • 2 cups of all-purpose flour
                        • 1 cup of sugar
                        • 2 tablespoons of cinnamon
                        • 5 peeled apples, sliced
                        • 1 ready-made pie crust
                    """.trimIndent(),
                    fontSize = 18.sp,  // Smaller size for content
                    color = Color(0xFF8B4513),  // SaddleBrown color for the text
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)  // Space between text and image
                )
            }

            // Image on the right
            Image(
                painter = painterResource(id = R.drawable.apple_pie_1),  // Add image resource
                contentDescription = "Apple Pie Image 1",
                modifier = Modifier
                    .size(150.dp)
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Row 2: Image on the left, Text on the right
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image on the left
            Image(
                painter = painterResource(id = R.drawable.apple_pie_2),  // Add another image resource
                contentDescription = "Apple Pie Image 2",
                modifier = Modifier
                    .size(190.dp)
                    .weight(1f)
            )

            // Recipe text on the right
            if (isRecipeVisible) {
                Text(
                    text = """
                        Instructions:
                        1. Preheat oven to 180°C.
                        2. Prepare the pie crust and fill it with the sliced apples.
                        3. Mix sugar and cinnamon, and sprinkle on top.
                        4. Bake for 45 minutes or until golden brown.
                    """.trimIndent(),
                    fontSize = 18.sp,  // Smaller size for content
                    color = Color(0xFF8B4513),  // SaddleBrown color for the text
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)  // Space between image and text
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button to toggle visibility of recipe text
        Button(onClick = {
            isRecipeVisible = !isRecipeVisible  // Toggle visibility
        }) {
            Text(text = if (isRecipeVisible) "Hide Recipe" else "Show Recipe")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeApp()
}
