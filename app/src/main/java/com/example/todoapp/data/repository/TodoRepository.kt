

interface TodoRepository{
    fun getAllTodos():Flow<:List<TodoItem>>
    suspend fun insertTodo(todo: TodoItem)
    suspend fun updateTodo(todo:TodoItem)
    suspend fun deleteTodo(todo:TodoItem)
    suspend fun toggleTodo(todo:TodoItem)
}