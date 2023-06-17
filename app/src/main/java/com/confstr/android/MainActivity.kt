@file:OptIn(ExperimentalMaterial3Api::class)

package com.confstr.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.confstr.android.ui.theme.ConfstrTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ConfstrTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting()
        }
      }
    }
  }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
  Column(modifier = Modifier.padding(24.dp)) {
    Text(
      text = "Welcome to Confstr!",
      modifier = modifier
    )
    Spacer(Modifier.size(20.dp))
    NostrLogin()
  }
}

@Composable
fun NostrLogin() {
  var conferenceRelay by remember { mutableStateOf("") }
  var conferencePubkey by remember { mutableStateOf("") }

  Column {
    Text(
      text = "Please enter Nostr connection information."
    )

    Spacer(Modifier.size(10.dp))

    Column {
      Text(
        text = "Relay for conference information"
      )
      TextField(
        value = conferenceRelay,
        onValueChange = { newText ->
          conferenceRelay = newText.trim()
        },
        placeholder = { Text("wss://relay.address") }
      )
    }

    Spacer(Modifier.size(10.dp))

    Column {
      Text(
        text = "Conference account public key"
      )
      TextField(
        value = conferencePubkey,
        onValueChange = { newText ->
          conferencePubkey = newText.trim()
        },
        placeholder = { Text("npub1...") }
      )
    }

    Button(
      onClick = {}
    ) {
      Text("Connect to see Conferences")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  ConfstrTheme {
    Greeting()
  }
}