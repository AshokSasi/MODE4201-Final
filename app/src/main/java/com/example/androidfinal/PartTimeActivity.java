package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PartTimeActivity extends AppCompatActivity {


    private Button btn_add, btn_listAll;
    private EditText et_name, et_age, et_lname,et_id,et_hours, et_rate;
    private int payroll;
    //private ListView lv_employeeList;

    private DatabaseHelper databaseHelper;


    private void calcPayroll(Employee employee)
    {
        payroll += employee.calcEarnings();


        Toast.makeText(PartTimeActivity.this,Integer.toString(payroll) , Toast.LENGTH_LONG).show();
        // System.out.println(payroll);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_time);


        btn_add = findViewById(R.id.btnAdd);
        // btn_listAll = findViewById(R.id.btnListAll);
        et_id = findViewById(R.id.txtID);
        et_age = findViewById(R.id.txtyear);
        et_name = findViewById(R.id.txtName);
        et_lname = findViewById(R.id.txtLName);
        et_hours = findViewById(R.id.txtHours);
        et_rate = findViewById(R.id.txtRate);
        // lv_employeeList = findViewById(R.id.lstEmployees);

        databaseHelper = new DatabaseHelper(PartTimeActivity.this);
        //  arrayAdapter = new ArrayAdapter<Employee>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEmployees() );

        //lv_employeeList.setAdapter(arrayAdapter);

        /**
         * Onclick for btn add
         */
        btn_add.setOnClickListener(new View.OnClickListener() {
            /**
             * Create a new employee object with inputs and insert into DB
             *
             * @param view
             */
            @Override
            public void onClick(View view) {

                try {

                    Employee PTEmployee = new PartTime(et_id.getText().toString(), et_name.getText().toString(), et_lname.getText().toString(),
                            Integer.parseInt(et_age.getText().toString()),
                            Integer.parseInt(et_hours.getText().toString()),
                            Integer.parseInt(et_rate.getText().toString()));

                    boolean success = databaseHelper.addPTOne(PTEmployee);


                    if (success) {
                        Toast.makeText(PartTimeActivity.this, "Added Employee", Toast.LENGTH_LONG).show();
                        // Toast.makeText(MainActivity.this, employeeModel.getEmpID(), Toast.LENGTH_LONG).show();
                        calcPayroll(PTEmployee);
                        databaseHelper = new DatabaseHelper(PartTimeActivity.this);
                    } else {
                        Toast.makeText(PartTimeActivity.this, "Employee already exists", Toast.LENGTH_LONG).show();
                    }


                } catch (Exception e) {
                    Toast.makeText(PartTimeActivity.this, "Failed to add Employee", Toast.LENGTH_LONG).show();
                }


//                   Toast.makeText(MainActivity.this, "Add button clicked", Toast.LENGTH_SHORT).show();


                //updateEmployeesList();


            }

        });

    }
}