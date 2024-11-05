package cl.emilym.kmp.parcelable.testapplication

import GreetingMessage
import android.os.Bundle
import android.os.Parcel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.bundleOf
import cl.emilym.kmp.parcelable.testapplication.ui.theme.ParcelableLibTheme
import kotlinx.parcelize.parcelableCreator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val parcel = Parcel.obtain()
        GreetingMessage("Hello Android!").writeToParcel(parcel, 0)
        parcel.setDataPosition(0)

        val message = parcelableCreator<GreetingMessage>().createFromParcel(parcel)

        enableEdgeToEdge()
        setContent {
            ParcelableLibTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        message = message,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(message: GreetingMessage, modifier: Modifier = Modifier) {
    Text(
        text = message.message,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParcelableLibTheme {
        Greeting(GreetingMessage("Hello Android!"))
    }
}