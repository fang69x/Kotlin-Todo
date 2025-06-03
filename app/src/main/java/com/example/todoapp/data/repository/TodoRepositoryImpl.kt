


class TodoRepositoryImpl(private val todoDao:TodoDao):TodoRepository{
    override fun getAllTodos():Flow<Llist<TodoItem>>{
        return todoDao.getAllTodos()
    }
    override suspend fun insertTodo(todo:TodoItem){
         todoDao.insertTodo(todo)
    }
    override suspend fun updateTodo(todo:TodoItem){
         todoDao.updateTodo(todo)

    }
    override suspend fun deleteTodo(todo:TodoItem){
         todoDao.deleteTodo(todo)
    }

    override suspend fun toggleTodo(todo:TodoItem){
        val updatedTodo=todo.copy(isCompleted=!todo.isCompleted)
        todoDao.updateTodo(updatedTodo)
    }

}