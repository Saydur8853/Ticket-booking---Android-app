package com.ticket.ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmAcivity extends AppCompatActivity {

    private String bus,classs,city,time,date,taka,doller,number,quantity;


    private TextView busTv,classTv,cityTv,timetv,dateTv,billTakatv,billDollerTv,quantityTv,phoneTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_acivity);
        setTitle("Confirm");

        init();
        showData();
    }

    private void showData() {
        bus=getIntent().getStringExtra("bus");
        busTv.setText(bus);
        classs=getIntent().getStringExtra("classs");
        classTv.setText(classs);
        city=getIntent().getStringExtra("city");
        cityTv.setText(city);
        time=getIntent().getStringExtra("time");
        timetv.setText(time);
        date=getIntent().getStringExtra("date");
        dateTv.setText(date);
        taka=getIntent().getStringExtra("billTaka");
        billTakatv.setText(taka);
        doller=getIntent().getStringExtra("billUsd");
        billDollerTv.setText(doller);
        number=getIntent().getStringExtra("phone");
        phoneTv.setText(number);
        quantity=getIntent().getStringExtra("quantity");
        quantityTv.setText(quantity);



    }

    private void init() {

        busTv=findViewById(R.id.busTv);
        classTv=findViewById(R.id.classTv);
        cityTv=findViewById(R.id.cityTv);
        timetv=findViewById(R.id.timeIv);
        dateTv=findViewById(R.id.dateTv);
        billTakatv=findViewById(R.id.takaTv);
        billDollerTv=findViewById(R.id.dollerTv);
        quantityTv=findViewById(R.id.quantityTv);
        phoneTv=findViewById(R.id.numberTv);



    }

    public void Confirm(View view) {

        Toast.makeText(this, "Ticket Order is confirm", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(ConfirmAcivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }

    @Override
    public void onBackPressed() {

        Intent intent=new Intent(ConfirmAcivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
