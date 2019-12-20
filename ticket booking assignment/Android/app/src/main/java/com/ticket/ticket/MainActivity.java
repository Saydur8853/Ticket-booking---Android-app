package com.ticket.ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String bus, city, quantity, date, classs, phone,billTakaAc,billTakaNonAc;

    double feniAc=350;
    double feniNonAc=290;
    double rajAc=400;
    double rajNonAc=350;
    double totalTicke;
    double noaAc=400;
    double noaNonAc=350;
    double barishalAc=500;
    double barishalNonAc=400;
    double billTaka,billDoller;
    String taka,doller;

    TextView dateTv;
    Button orderBtn;

    private EditText numberEt;

    Spinner bussp, citysp, quantitysp, classsp;


    private String[] selectbus;
    ArrayAdapter<String> busAdapter;

    private String[] selectcity;
    ArrayAdapter<String> cityAdapter;

    private String[] selectquantity;
    ArrayAdapter<String> quantityAdapter;

    private String[] selectclass;
    ArrayAdapter<String> classAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        dateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datepiker();

            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bus = bussp.getSelectedItem().toString().trim();
                city = citysp.getSelectedItem().toString().trim();
                quantity = quantitysp.getSelectedItem().toString().trim();







                classs = classsp.getSelectedItem().toString();
                date = dateTv.getText().toString().trim();
                phone = numberEt.getText().toString().trim();
                if(!bus.equals("Select Bus")&&!city.equals("Select District")&&!classs.equals("Select Class")&&!quantity.equals("Select Quantity")&&!date.equals("")&&!phone.equals("")){
                    if(phone.length()>10 && phone.length()<12){
                        order();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid Number", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this, "Something is not define", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void datepiker() {

        DatePickerDialog.OnDateSetListener dateSetListener =
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        month = month + 1;
                        String currentDate = year + "/" + month + "/" + day;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

                        Date date = null;

                        try {
                            date = dateFormat.parse(currentDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        dateTv.setText(dateFormat.format(date));
                        long dateInmilis = date.getTime();

                    }
                };

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener, year, month, day);
        datePickerDialog.show();

    }

    private void init() {
        orderBtn=findViewById(R.id.orderBtn);

        numberEt = findViewById(R.id.numberEt);
        dateTv = findViewById(R.id.dateTv);

        citysp = findViewById(R.id.districtsp);
        selectcity = getResources().getStringArray(R.array.Select_district);
        cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, selectcity);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        citysp.setAdapter(cityAdapter);

        classsp = findViewById(R.id.classsp);
        selectclass = getResources().getStringArray(R.array.Select_class);
        classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, selectclass);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        classsp.setAdapter(classAdapter);

        quantitysp = findViewById(R.id.quantitysp);
        selectquantity = getResources().getStringArray(R.array.Select_quantity);
        quantityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, selectquantity);
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        quantitysp.setAdapter(quantityAdapter);

        bussp = findViewById(R.id.bussp);
        selectbus = getResources().getStringArray(R.array.Select_bus);
        busAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, selectbus);
        busAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bussp.setAdapter(busAdapter);


    }

    public void order() {






        if (city.equals("Feni")) {
            //Integer.parseInt(myString);
            totalTicke=Integer.parseInt(quantity);


            if(classs.equals("AC")){

                billTaka=feniAc*totalTicke;

                billDoller=billTaka/85;
                billDoller = billDoller*100;
                billDoller = Math.round(billDoller);
                billDoller = billDoller /100;
                taka=String.valueOf(billTaka);
                doller=String.valueOf(billDoller);

            }
            else {
                billTaka=feniNonAc*totalTicke;
                billDoller=billTaka/85;
                billDoller = billDoller*100;
                billDoller = Math.round(billDoller);
                billDoller = billDoller /100;
                taka=String.valueOf(billTaka);
                doller=String.valueOf(billDoller);

            }



            String time = "16HH:7MM";


            Intent intent=new Intent(MainActivity.this,ConfirmAcivity.class);
            intent.putExtra("bus",bus);
            intent.putExtra("classs",classs);
            intent.putExtra("city",city);
            intent.putExtra("time",time);
            intent.putExtra("date",date);
            intent.putExtra("phone",phone);
            intent.putExtra("quantity",quantity);
            intent.putExtra("billTaka",taka);
            intent.putExtra("billUsd",doller);

            startActivity(intent);
        }

        else if (city.equals("Rajshahi")) {
            totalTicke=Integer.parseInt(quantity);


            if(classs.equals("AC")){

                billTaka=rajAc*totalTicke;
                billDoller=billTaka/85;
                billDoller = billDoller*100;
                billDoller = Math.round(billDoller);
                billDoller = billDoller /100;
                taka=String.valueOf(billTaka);
                doller=String.valueOf(billDoller);

            }
            else {
                billTaka=rajNonAc*totalTicke;


                billDoller=billTaka/85;
                billDoller = billDoller*100;
                billDoller = Math.round(billDoller);
                billDoller = billDoller /100;
                taka=String.valueOf(billTaka);
                doller=String.valueOf(billDoller);

            }



            String time = "19HH:52MM";


            Intent intent=new Intent(MainActivity.this,ConfirmAcivity.class);
            intent.putExtra("bus",bus);
            intent.putExtra("classs",classs);
            intent.putExtra("city",city);
            intent.putExtra("time",time);
            intent.putExtra("date",date);
            intent.putExtra("phone",phone);
            intent.putExtra("quantity",quantity);
            intent.putExtra("billTaka",taka);
            intent.putExtra("billUsd",doller);

            startActivity(intent);

        } else if (city.equals("Noakhali")) {
            totalTicke=Integer.parseInt(quantity);


            if(classs.equals("AC")){

                billTaka=noaAc*totalTicke;
                billDoller=billTaka/85;
                billDoller = billDoller*100;
                billDoller = Math.round(billDoller);
                billDoller = billDoller /100;
                taka=String.valueOf(billTaka);
                doller=String.valueOf(billDoller);

            }
            else {
                billTaka=noaNonAc*totalTicke;
                billDoller=billTaka/85;
                billDoller = billDoller*100;
                billDoller = Math.round(billDoller);
                billDoller = billDoller /100;
                taka=String.valueOf(billTaka);
                doller=String.valueOf(billDoller);

            }



            String time = "12HH:10MM";


            Intent intent=new Intent(MainActivity.this,ConfirmAcivity.class);
            intent.putExtra("bus",bus);
            intent.putExtra("classs",classs);
            intent.putExtra("city",city);
            intent.putExtra("time",time);
            intent.putExtra("date",date);
            intent.putExtra("phone",phone);
            intent.putExtra("quantity",quantity);
            intent.putExtra("billTaka",taka);
            intent.putExtra("billUsd",doller);

            startActivity(intent);
        }

        else if (city.equals("Borishal")) {
            totalTicke=Integer.parseInt(quantity);

            if(classs.equals("AC")){

                billTaka=barishalAc*totalTicke;
                billDoller=billTaka/85;
                billDoller = billDoller*100;
                billDoller = Math.round(billDoller);
                billDoller = billDoller /100;
                taka=String.valueOf(billTaka);
                doller=String.valueOf(billDoller);

            }
            else {
                billTaka=barishalNonAc*totalTicke;
                billDoller=billTaka/85;
                billDoller = billDoller*100;
                billDoller = Math.round(billDoller);
                billDoller = billDoller /100;
                taka=String.valueOf(billTaka);
                doller=String.valueOf(billDoller);

            }



            String time = "11HH:13MM";


            Intent intent=new Intent(MainActivity.this,ConfirmAcivity.class);
            intent.putExtra("bus",bus);
            intent.putExtra("classs",classs);
            intent.putExtra("city",city);
            intent.putExtra("time",time);
            intent.putExtra("date",date);
            intent.putExtra("phone",phone);
            intent.putExtra("quantity",quantity);
            intent.putExtra("billTaka",taka);
            intent.putExtra("billUsd",doller);
            startActivity(intent);



        }



    }
}
