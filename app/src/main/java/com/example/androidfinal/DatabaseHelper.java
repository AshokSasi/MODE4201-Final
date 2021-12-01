package com.example.androidfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String EMPLOYEE_TABLE = "EMPLOYEE_TABLE";
    public static final String COLUMN_EMPLOYEE_FNAME = "EMPLOYEE_FNAME";
    public static final String COLUMN_EMPLOYEE_LNAME = "EMPLOYEE_LNAME";
    public static final String COLUMN_EMPLOYEE_DOB = "EMPLOYEE_DOB";

    public static final String COLUMN_ID = "ID";


    public DatabaseHelper(@Nullable Context context) {
        super(context, "employee.db", null, 1);
    }

    /**
     * Creates the employee table
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStmt = "CREATE TABLE EMPLOYEE_TABLE(" + COLUMN_ID + " TEXT PRIMARY KEY , " + COLUMN_EMPLOYEE_FNAME + " TEXT, " + COLUMN_EMPLOYEE_LNAME + " TEXT, " + COLUMN_EMPLOYEE_DOB + " INTEGER)";

        db.execSQL(createStmt);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    /**
     * Adds one employee to the database
     * @param employeeModel
     * @return
     */
    public boolean addOne(Employee employeeModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, employeeModel.getEmpID());
        cv.put(COLUMN_EMPLOYEE_FNAME, employeeModel.getFirstName());
        cv.put(COLUMN_EMPLOYEE_LNAME, employeeModel.getLastName());
        cv.put(COLUMN_EMPLOYEE_DOB, employeeModel.getBirthYear());


        long result = db.insert(EMPLOYEE_TABLE,null ,cv);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Deletes one employee from the database
     * @param emp
     * @return
     */
    public boolean deleteOne (EmployeeModel emp) {
        SQLiteDatabase db = this.getWritableDatabase();
        String stmt = "DELETE FROM " + EMPLOYEE_TABLE + " WHERE " + COLUMN_ID + " = " + emp.getId();

        Cursor cursor = db.rawQuery(stmt, null);

        if (cursor.moveToFirst()) {
            return true;
        }
        return false;
    }

    /**
     * Gets all employees from the database and adds them to a list
     * @return List<EmployeeModel></EmployeeModel>
     */
    List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<Employee>();

        String querystmt = "SELECT * FROM " + EMPLOYEE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(querystmt, null);

        if (cursor.moveToFirst()) {
            do {
                String empID = cursor.getString(0);
                String empName = cursor.getString(1);
                String empLName = cursor.getString(2);
                int empAge = cursor.getInt(3);


                Employee newEmp = new FullTime(empID, empName,empLName ,empAge,20,20);
                list.add(newEmp);
            } while (cursor.moveToNext());
        } else {
            // error ..
        }

        cursor.close();
        db.close();

        return list;
    }


}