package santosoftvw.com.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class AttendanceActivity extends AppCompatActivity {
    TableLayout tableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        tableLayout.setColumnStretchable(0, true);
        tableLayout.setColumnStretchable(1, true);

        final AttendanceDb db = new AttendanceDb(this);
        List<Attendance> attendance = db.getAllAttendance();

        for (Attendance at : attendance) {
            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundResource(R.drawable.border);
            TextView roll = new TextView(this);
            roll.setBackgroundResource(R.drawable.border);
            TextView attended = new TextView(this);
            attended.setBackgroundResource(R.drawable.border);
            roll.setText(at.getRollNo() );
            attended.setText(String.valueOf(at.isAttended()));
            roll.setTextSize(15);
            roll.setGravity(Gravity.CENTER);
            attended.setTextSize(15);
            attended.setGravity(Gravity.CENTER);
            tableRow.addView(roll);
            tableRow.addView(attended);
            tableLayout.addView(tableRow);
        }
    }
}