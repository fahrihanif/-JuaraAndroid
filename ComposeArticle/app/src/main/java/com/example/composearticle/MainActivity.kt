package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleApp()
                }
            }
        }
    }
}

@Composable
fun ArticleApp() {
    Column {
        ArticleImage(
            headerImage = painterResource(id = R.drawable.bg_compose_background)
        )
        ArticleText(
            title = stringResource(R.string.title_text),
            firstParagraph = stringResource(R.string.first_paragraph_text),
            secondParagraph = stringResource(R.string.second_paragraph_text)
        )
    }
}

@Composable
fun ArticleText(title: String, firstParagraph: String, secondParagraph: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = firstParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                )
        )
        Text(
            text = secondParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun ArticleImage(headerImage: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = headerImage,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ArticleApp()
    }
}