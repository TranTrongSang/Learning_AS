package com.example.project_createabusinesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_createabusinesscardapp.ui.theme.ProjectCreateABusinessCardAppTheme
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.widget.ImageView;
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectCreateABusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        Greeting()
                }
            }
        }
    }
}


@Composable
fun MyIcon(icon: ImageVector, tint: Color, contentDescription: String?) {
    Icon(
        imageVector = icon,
        tint = tint,
        contentDescription = contentDescription,
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
fun Information(icon: ImageVector, tint: Color, text: String, modifier: Modifier = Modifier){
    Row (
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        MyIcon(
            icon = icon,
            tint = tint,
            contentDescription = null
        )
        Text(text = text, fontSize = 20.sp, color = Color.White)
    }
}
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        
    ){
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.padding(bottom = 30.dp)

        )
        Text(
            text = "Tran Trong Sang",
            fontSize = 30.sp,
            color = Color.White
        )
        Text(
            text = "Mobile Developer, Data Analyst",
            modifier = Modifier.padding(),
            color = Color.White
        )
        Column(
            modifier = modifier
                .padding(top = 150.dp, bottom = 0.dp)
        ){
            Information(icon = Icons.Filled.Phone, tint = Color.Green, text = "0375760xxx")
            Information(icon = Icons.Filled.Share, tint = Color.Green, text = "@SangTranuit")
            Information(icon = Icons.Filled.MailOutline, tint = Color.Green, text = "20521834@gm.uit.edu.vn")
            }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectCreateABusinessCardAppTheme {
        Greeting()
    }
}

