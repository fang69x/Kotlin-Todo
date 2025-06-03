@Entity(tabvleName = "todos")
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0
    val text:String,
    val isCoompeted:Boolean=false
    val createdAt:Long=System.currentTimeMillis()
)

