package com.example.alltaskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alltaskcompleted.ui.theme.AllTaskCompletedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllTaskCompletedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FinishedImage(
                        text1 = stringResource(R.string.all_tasks_completed_text),
                        text2 = stringResource(R.string.compliment_text) )
                }
            }
        }
    }
}

@Composable
fun Greeting(text1: String, text2: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    )
    {
        Text(
            text = text1,
            fontWeight = Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
                .align(Alignment.CenterHorizontally),

        )
        Text(
            text = text2,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),

            )
    }

}


@Composable
fun FinishedImage(text1: String, text2: String, modifier: Modifier = Modifier)
{
    val image = painterResource(id = R.drawable.ic_task_completed)
    Box(

    )
    {
        Image(
            painter = image,
            contentDescription = null,
            )
        Greeting(
            text1 = text1,
            text2 = text2,
            modifier = Modifier.padding(top = 211.dp, start = 34.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AllTaskCompletedTheme {
        FinishedImage(
            text1 = stringResource(R.string.all_tasks_completed_text),
            text2 = stringResource(R.string.compliment_text) )
    }
}