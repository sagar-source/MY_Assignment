package com.example.myassignment.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myassignment.Adapter.CountryAdapter;
import com.example.myassignment.Model.country;

import com.example.myassignment.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CountryAdapter countryAdapter;
    List<country> countryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setTitle("Second Screen");

        countryList.add(new country("India",getTime("GMT+5:30")));
        countryList.add(new country("UK",getTime("GMT+12:30")));
        countryList.add(new country("USA",getTime("GMT+00:00")));
        countryList.add(new country("Pakistan",getTime("GMT+4:30")));
        countryList.add(new country("China",getTime("GMT+4:00")));
        countryList.add(new country("Australia",getTime("GMT-3:30")));
        countryList.add(new country("Egypt",getTime("GMT+00:30")));
        countryList.add(new country("India1",getTime("GMT+5:30")));
        countryList.add(new country("UK1",getTime("GMT+12:30")));
        countryList.add(new country("USA1",getTime("GMT+00:00")));
        countryList.add(new country("Pakistan1",getTime("GMT+4:30")));
        countryList.add(new country("China1",getTime("GMT+4:00")));
        countryList.add(new country("Australia1",getTime("GMT-3:30")));
        countryList.add(new country("Egypt1",getTime("GMT+00:30")));
        countryList.add(new country("India2",getTime("GMT+5:30")));
        countryList.add(new country("UK2",getTime("GMT+12:30")));
        countryList.add(new country("USA2",getTime("GMT+00:00")));
        countryList.add(new country("Pakistan2",getTime("GMT+4:30")));
        countryList.add(new country("China2",getTime("GMT+4:00")));
        countryList.add(new country("Australia2",getTime("GMT-3:30")));
        countryList.add(new country("Egypt2",getTime("GMT+00:30")));

        recyclerView = findViewById(R.id.recycler);

        countryAdapter = new CountryAdapter(this,countryList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(countryAdapter);

    }

    private String getTime(String s) {

        TimeZone tz = TimeZone.getTimeZone(s);
        Calendar c = Calendar.getInstance(tz);
        String time = String.format("%02d" , c.get(Calendar.MINUTE))+":"+String.format("%02d" , c.get(Calendar.SECOND))+":"+String.format("%03d" , c.get(Calendar.MILLISECOND));

        return time;
    }

}
