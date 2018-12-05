package com.apps.jivory.collegeapp.architecture;

import android.content.Context;
import android.os.AsyncTask;

import com.apps.jivory.collegeapp.models.College;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


/** Entities that the database contains are defined in tag
 *  Version number is for new migrations
 *  By default exportSchema is set and will create a json file with Database schema.
 */
@Database(entities = {College.class}, version = 1)
public abstract class CollegeDatabase extends RoomDatabase {
    private static CollegeDatabase instance;

    public abstract CollegeDao collegeDao();

    public static synchronized CollegeDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), CollegeDatabase.class, "parkinglot_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();

        }
        return instance;
    }

    /** This is a way to prepopulate a database after destroyed and recreated.
     *
     */
    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new NewCollegeDatabaseAsyncTask(instance).execute();
        }
    };

    private static class NewCollegeDatabaseAsyncTask extends AsyncTask<Void, Void, Void> {
        //MUST IMPLEMENT**
        private CollegeDao collegeDao;

        public NewCollegeDatabaseAsyncTask(CollegeDatabase database){
            collegeDao = database.collegeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }


}
