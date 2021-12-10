package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_add, btn_listAll;
    private EditText et_name, et_age, et_lname,et_id;

    //private ListView lv_employeeList;

    private DatabaseHelper databaseHelper;
    private ArrayAdapter arrayAdapter;


    /**
     * Updates the list view by calling the aray adapter and setting it to the list view
     */
//    private void updateEmployeesList(){
//        arrayAdapter = new ArrayAdapter<Employee>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEmployees() );
//        lv_employeeList.setAdapter(arrayAdapter);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btnAdd);
       // btn_listAll = findViewById(R.id.btnListAll);
        et_id = findViewById(R.id.txtID);
        et_age = findViewById(R.id.txtyear);
        et_name = findViewById(R.id.txtName);
        et_lname = findViewById(R.id.txtLName);
       // lv_employeeList = findViewById(R.id.lstEmployees);

        databaseHelper = new DatabaseHelper(MainActivity.this);
      //  arrayAdapter = new ArrayAdapter<Employee>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEmployees() );

        //lv_employeeList.setAdapter(arrayAdapter);

        /**
         * Onclick for btn add
         */
        btn_add.setOnClickListener(new View.OnClickListener() {
            /**
             * Create a new employee object with inputs and insert into DB
             * @param view
             */
            @Override
            public void onClick(View view) {
                Employee employeeModel = new FullTime(et_id.getText().toString(),et_name.getText().toString(),et_lname.getText().toString(), Integer.parseInt(et_age.getText().toString()),20,20);
                Toast.makeText(MainActivity.this, "Add button clicked", Toast.LENGTH_SHORT).show();

                 databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean success = databaseHelper.addFTOne(employeeModel);
                //updateEmployeesList();

                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
            }

        });

        /**
         * Displays all of the database entries
         */
//        btn_listAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                List<Employee> listEmp = databaseHelper.getEmployees();
//                lv_employeeList.setAdapter(arrayAdapter);
//
//                //Toast.makeText(MainActivity.this, listEmp.toString(), Toast.LENGTH_LONG).show();
//            }
//        });

        /**
         * Deletes the item that was clicked
         */
//        lv_employeeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Employee clickedEmployee = (Employee) parent.getItemAtPosition(position);
//                databaseHelper.deleteOne(clickedEmployee);
//                updateEmployeesList();
//                Toast.makeText(MainActivity.this, "Deleted !", Toast.LENGTH_LONG).show();
//            }
//        });


    }
}