package cl.bootcamp.myapplication7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cl.bootcamp.myapplication7.ui.theme.MyApplication7Theme
import cl.bootcamp.myapplication7.ui.theme.MainScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication7Theme {
                MainScreen()
            }
        }
    }
}
