package com.example.todoapp.data.local

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@OptInExperimentalMaterial3Api::class)
        class MainActivity:ComponentActivity(){
            override fun onmCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                val database=TodoDatabse.getDatabase(this)
                val repository TodoReepositoryImpl(database.todoDao())


                setContent {
                    TodoApp(repository=repository)
                }
            }
        }
@OptInExperimentalMaterial3Api
@Composable
fun TodoApp(repository: TodoRepositoryImpl){
    val viewModel:MainViewModel=vieModel{
        MainViewModel(repository)
        val uiState by viewModel.uiState.collectAsState()
        val newTodoText = remember { mutableStateOf("") }
        Column(
            s
        )
    }
}
