package data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gymme.data.data.LocalMetrics
import com.gymme.data.data.LocalUser

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun get(): List<LocalUser>?

    @Insert
    suspend fun insert(user: LocalUser)
}