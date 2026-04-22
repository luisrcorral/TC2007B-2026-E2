package com.example.tc2007b_2026_e2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.tc2007b_2026_e2.ui.theme.TC2007B2026E2Theme

class TargetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TC2007B2026E2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        myViewModel = receivedParamViewModel(),
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

class receivedParamViewModel : ViewModel() {
    var p_uname by mutableStateOf("")
    var p_ulname by mutableStateOf("")

}


@SuppressLint("ContextCastToActivity")
@Composable
fun Greeting2(myViewModel: receivedParamViewModel, name: String, modifier: Modifier = Modifier) {

    val myContext = LocalContext.current as? ComponentActivity
    //Get Extra is not overloaded, you require to express the type of the data

    myViewModel.p_uname = myContext?.intent?.getStringExtra("uname")?: "No data"
    myViewModel.p_ulname = myContext?.intent?.getStringExtra("ulname")?: "No data"
    Column(modifier = modifier) {
    Text(
        text = "Username = " + myViewModel.p_uname + " UserLastname = " + myViewModel.p_ulname,
        modifier = modifier
    )

    Image(
        painter = painterResource(id = R.drawable.jetpack_compose),
        contentDescription = "Jetpack Compose",
        modifier = modifier
    )
    }
}
