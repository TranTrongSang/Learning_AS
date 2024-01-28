package com.example.learntogether

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun DescribedParagraph(titleOfTheScreen: String, firstParagraph: String, secondParagraph: String, modifier: Modifier = Modifier) {
    Column(

        modifier = modifier,
    )
    {
        Text(
            text = titleOfTheScreen,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp),
        )
        Text(
            text = firstParagraph,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )
        Text(
            text = secondParagraph,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }

}

@Composable

fun DescribedImage(titleOfTheScreen: String, firstParagraph: String, secondParagraph: String, modifier: Modifier = Modifier)
{
    val image = painterResource(id = R.drawable.bg_compose_background)
    Box{
        Image(
            painter = image,
            contentDescription = null,
        )
        DescribedParagraph(
            titleOfTheScreen = titleOfTheScreen,
            firstParagraph = firstParagraph,
            secondParagraph = secondParagraph,
            modifier = Modifier.padding(top = 118.dp)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        DescribedImage(
            titleOfTheScreen = stringResource(R.string.title_tutorial_text),
            firstParagraph = stringResource(R.string.first_paragraph_text),
            secondParagraph = stringResource(R.string.second_paragraph_text)
        )
    }
}