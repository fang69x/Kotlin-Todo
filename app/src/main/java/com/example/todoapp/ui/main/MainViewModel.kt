import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourname.todoapp.data.model.TodoItem
import com.yourname.todoapp.data.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

package com.yourname.todoapp.ui.main
class MainViewModel(private val repository:TodoRepository):ViewModel(){
    private val _uiState=MutableStateFlow(TodoUiState())
    val uiState:StateFlow<TodoUiState>=_uiState.asStateFlow()

            init()
    {
                LoadTodos()
            }
    private fun LoadTodos(){
        viewModelScope.launch{
            repository.getAllTodos().collect{
                todos->_uiState.value=uiState.value.copy(
                    todos=todos,
                    isLoading=false

                )
            }
        }
    }

fun addTodo(text:String){
    if(text.isBlank())  return
    viewModelScope.launch{
        val newTodo=TodoItem(text=text.trim())
        repository.insertTodo(newTodo)
    }
}
    fun toggleTodo(todo TodoItem){
        viewNModelScope.launch{
            repository.toggleTodo(todo)
        }
    }
    fun deleteTodo(todo:TodoItem){
        viewModelScope.launch{
            repository.deleteTodo(todo)
        }
    }
    fun updateTodo(todo: TodoItem) {
        viewModelScope.launch {
            repository.updateTodo(todo)
        }
    }
    data class TodoUiState(
        val todos:List<TodoItem>=emptyList()
        val isLoading:Boolean=true
        val errorMessage:String?=null
    )

}