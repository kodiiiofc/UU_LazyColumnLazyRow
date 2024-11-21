package com.kodiiiofc.urbanuniversity.jetpackcompose.lazycolumnlazyrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodiiiofc.urbanuniversity.jetpackcompose.lazycolumnlazyrow.ui.theme.LazyColumnLazyRowTheme

private val fruit = listOf(
    Item("Apple", R.drawable.apple),
    Item("Grape", R.drawable.grape),
    Item("Melon", R.drawable.melon),
    Item("Orange", R.drawable.orange),
    Item("Peach", R.drawable.peach),
    Item("Pear", R.drawable.pear),
    Item("Pineapple", R.drawable.pineapple)
)

private val vegetables = listOf(
    Item("Carrot", R.drawable.carrot),
    Item("Cucumber", R.drawable.cucumber),
    Item("Onion", R.drawable.onion),
    Item("Pepper", R.drawable.pepper),
    Item("Potato", R.drawable.potato),
    Item("Tomato", R.drawable.tomato)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen()
        }
    }
}

data class Item(val name: String, val imageResource: Int)

@Preview
@Composable
fun ScreenPreview() {
    Screen()
}

@Composable
fun Screen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    )  {
        Text(
            text = "Фрукты",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Black)
                .padding(4.dp)
        )
        LazyRow(
            modifier = Modifier
                .padding(8.dp)
                .border(1.dp, Color.Black)
        ) {
            items(fruit) {
                ItemCeil(it)
            }

        }
        Text(
            text = "Овощи",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Black)
                .padding(4.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Black)
        ) {
            items(vegetables) {
                ItemCeil(it)
            }
        }
    }
}

@Composable
fun ItemCeil(item: Item) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp)
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(item.imageResource),
            contentDescription = "",
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp))

        Text(
            text = item.name,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )

    }
}