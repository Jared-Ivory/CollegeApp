package com.apps.jivory.collegeapp.architecture;

import com.apps.jivory.collegeapp.models.College;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * DAO or Data Access Object
 * Contain query methods that interact with the database.
 */


@Dao
public interface CollegeDao {

    @Insert
    void insert(College... college);

    @Delete
    void delete(College college);


    @Query("Delete FROM college_table")
    void deleteAllColleges();

}
