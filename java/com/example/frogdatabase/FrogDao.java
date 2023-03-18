package com.example.frogdatabase;
import androidx.room.*;
import com.example.frogdatabase.Frog;
import java.util.List;

import javax.security.auth.Subject;

@Dao
public interface FrogDao {
    @Query("SELECT * FROM Frog WHERE mId = :id")
    Subject getSubject(long id);

    @Query("SELECT * FROM Frog ORDER BY mDescription COLLATE NOCASE")
    List<Subject> getSubjects();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addSubject(Subject subject);

    @Update
    void updateSubject(Subject subject);

    @Delete
    void deleteSubject(Subject subject);
}
