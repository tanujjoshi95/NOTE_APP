package com.example.note2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.note2.Screen.NoteScreen
import com.example.note2.Screen.viewModelNotes
import com.example.note2.ui.theme.Note2Theme
import dagger.hilt.android.AndroidEntryPoint

//@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Note2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteViewModel=viewModel<viewModelNotes>()
                  //  val noteViewModel:viewModelNotes by viewModels()
                    NoteApp(noteViewModel)
                }


                }
            }
        }
    }



@Composable
fun NoteApp(noteViewModel: viewModelNotes) {
    val noteList=noteViewModel.noteList.collectAsState().value
    NoteScreen(notes =  noteList,
        onAddNote ={ noteViewModel.addNote(it)},
        onRemoveNote = { noteViewModel.removeNote(it) }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Note2Theme {
//        Greeting("Android")
//    }
//}