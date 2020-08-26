package santosoftvw.com.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    //instance variable
    private EditText txtRollNo;
    private EditText txtRollNo;
    private EditText txtRollNo;
    private CheckBox chkAttend;
    private Button btnSave;
    /*
    editTxtRollNo
    editTextDate
    editTxtCourse
    chkAttend
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRollNo = (EditText)findViewById(R.id.editTxtRollNo);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //txtRollNo.setText("Button Clicked");
                //SQLite Database
                
            }
        });

    }
}