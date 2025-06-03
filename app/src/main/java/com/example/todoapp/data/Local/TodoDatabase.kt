import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
@Database
    (
            entities=[TodoItem::class],
            version:1,
            exportSchema=false
            )
        abstract class TodoDatabase:RoomDatabase(){
            abstract fun todoDao():TodoDao
            companion object{
                @Volatile
                private var INSTANCE:TodoDatabase?=null
                fun getDatabase(context:Context):TodoDatabase{
                    return INSTANCE?:synchronised(this){
                        val instance=Room.databaseBuilder(
                            context.applicationContext,
                            TodoDatabse::class.java,
                            "todo_database"

                        ).build()
                        INSTANCE=instance
                        instance

                    }
                }
            }
        }