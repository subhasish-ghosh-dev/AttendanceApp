package santosoftvw.com.attendanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

import java.util.ArrayList;
import java.util.List;


public class AttendanceDb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "attendancedb";
    private static final String TABLE_ATTENDANCE = "attendance";
    private static final String KEY_ID = "id";
    private static final String KEY_ROLL = "roll";
    private static final String KEY_CLASS = "class";
    private static final String KEY_COURSE = "course";
    private static final String KEY_ATTENDED = "attended";

    public AttendanceDb( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ATTENDANCE_TABLE = "CREATE TABLE " + TABLE_ATTENDANCE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ROLL + " TEXT,"
                + KEY_CLASS + " TEXT, " + KEY_COURSE + " TEXT, " + KEY_ATTENDED + " TEXT " + ")";
        sqLiteDatabase.execSQL(CREATE_ATTENDANCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    public void addAttendance(Attendance attendance) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ROLL, attendance.getRollNo());
        values.put(KEY_CLASS, attendance.getDateClass());
        values.put(KEY_COURSE, attendance.getCourseCode());
        values.put(KEY_ATTENDED, String.valueOf(attendance.isAttended()));

        db.insert(TABLE_ATTENDANCE, null, values);
        db.close();
    }

    public List<Attendance> getAllAttendance() {
        List<Attendance> attendanceList = new ArrayList<Attendance>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ATTENDANCE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Attendance attendance = new Attendance();
                attendance.setId(Integer.parseInt(cursor.getString(0)));
                attendance.setRollNo(cursor.getString(1));
                attendance.setDateClass(cursor.getString(2));
                attendance.setCourseCode(cursor.getString(3));
                attendance.setAttended(Boolean.parseBoolean(cursor.getString(4)));

                attendanceList.add(attendance);
            } while (cursor.moveToNext());
        }

        // return contact list
        return attendanceList;
    }
}
