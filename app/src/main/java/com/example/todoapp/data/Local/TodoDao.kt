@Dao
interface TodoDao{
    @Query("Select*FROM todos ORDER BY createdAt DESC")
    fun getAllTodos():Flow<List<TodoItem>>
    @Insert
    suspend fun insertTodo(todo:TodoItem)
    @Update
    suspend fun updateTodo(todo:TodoItem)
    @Delete
    suspend fun deleteTodo(todo:TodoItem)
    @Query("DELETE FROM todos WHERE id=:id")
    suspend fun deleteTodoById(id:Int)
}