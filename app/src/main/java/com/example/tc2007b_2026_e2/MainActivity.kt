package com.example.tc2007b_2026_e2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.tc2007b_2026_e2.ui.theme.TC2007B2026E2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TC2007B2026E2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        viewModel = paramViewModel(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

class paramViewModel : ViewModel() {
    var user_name by mutableStateOf("")
    var user_lastname by mutableStateOf("")
}



@Composable
fun Greeting(viewModel: paramViewModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Write your name"
        )
        TextField(
            value = viewModel.user_name,
            onValueChange = { viewModel.user_name = it},
            label = { Text("Type your name") }
        )
        Text(
            text = "Write your lastname"
        )
        TextField(
            value = viewModel.user_lastname,
            onValueChange = { viewModel.user_lastname = it},
            label = { Text("Type your Lastname") }
        )

        val myContext = LocalContext.current
        Button(onClick = {

            val intent = Intent(myContext, TargetActivity::class.java)
            intent.putExtra("uname", viewModel.user_name)
            intent.putExtra("ulname", viewModel.user_lastname)
            myContext.startActivity(intent)
        })
        {
            Text(text = "Submit")
        }
    }
}