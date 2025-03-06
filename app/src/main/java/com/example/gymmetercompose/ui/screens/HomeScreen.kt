package com.example.gymmetercompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymmetercompose.R
import com.example.gymmetercompose.ui.theme.myBackground

@Composable
fun HomeScreen(navController: NavController) {
    HomeScreenContent()
}

@Composable
fun HomeScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(myBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 20.dp, bottom = 20.dp) // Agregamos padding superior e inferior
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.image1),
                    contentDescription = "Imagen 1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f) // Aumentamos la altura
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(17.dp))
                        .aspectRatio(1.5f), // Aumentamos la relación de aspecto (Altura)
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f) // Reducimos la altura
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image2),
                        contentDescription = "Imagen 2",
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(17.dp))
                            .aspectRatio(0.5f),
                        contentScale = ContentScale.Crop
                    )
                    Image(
                        painter = painterResource(id = R.drawable.image3),
                        contentDescription = "Imagen 3",
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(17.dp))
                            .aspectRatio(0.5f),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.image4),
                    contentDescription = "Imagen 4",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f) // Aumentamos la altura
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(17.dp))
                        .aspectRatio(1.5f), // Aumentamos la relación de aspecto (Altura)
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenContent()
}