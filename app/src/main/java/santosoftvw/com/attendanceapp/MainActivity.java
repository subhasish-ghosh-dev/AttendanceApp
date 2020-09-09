package santosoftvw.com.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //instance variable
    private EditText txtRollNo;
    private EditText txtDate;
    private EditText txtCourse;
    private CheckBox chkAttend;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRollNo = (EditText)findViewById(R.id.editTxtRollNo);
        txtDate = (EditText)findViewById(R.id.editTextDate);
        txtCourse = (EditText)findViewById(R.id.editTxtCourse);
        chkAttend = (CheckBox)findViewById(R.id.chkAttend);
        btnSave = (Button)findViewById(R.id.btnSave);
        final AttendanceDb db = new AttendanceDb(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Insert: ", "Inserting ..");

                db.addAttendance(new Attendance( txtRollNo.getText().toString(), txtDate.getText().toString(),
                        txtCourse.getText().toString(), chkAttend.isChecked()));
                /*
                //Log.d("Reading: ", "Reading all Attendance..");
                List<Attendance> attendance = db.getAllAttendance();
                String log = "\n";    
                for (Attendance at : attendance) {
                     log+="Id: " + at.getId() + " ,Roll NO: " + at.getRollNo() + " ,Class Date: " +
                            at.getDateClass() + " , Course Code: " + at.getCourseCode() +" , Class Attended: " + at.isAttended();
                    Toast toast=Toast.makeText(getApplicationContext(),log,Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                    //Log.d("Attendance: ", log);
                }*/
                Intent intent = new Intent(MainActivity.this,AttendanceActivity.class);
                startActivity(intent);
            }
        });

    }
}