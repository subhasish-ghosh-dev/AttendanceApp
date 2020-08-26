package santosoftvw.com.attendanceapp;

public class Attendance {
    private int id;
    private String rollNo;
    private String dateClass;
    private String courseCode;
    private boolean attended;

    public Attendance(){

    }
    public Attendance(int _id, String _roll, String _classDt, String _codeCourse, boolean _attended){
        this.id=_id;
        this.rollNo=_roll;
        this.dateClass =_classDt;
        this.courseCode=_codeCourse;
        this.attended=_attended;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getDateClass() {
        return dateClass;
    }

    public void setDateClass(String dateClass) {
        this.dateClass = dateClass;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
