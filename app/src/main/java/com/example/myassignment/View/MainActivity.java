package com.example.myassignment.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myassignment.Adapter.TopicAdapter;
import com.example.myassignment.Model.phrases;
import com.example.myassignment.Model.response;
import com.example.myassignment.Model.topics;
import com.example.myassignment.R;
import com.example.myassignment.ViewModel.TopicViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TopicAdapter adapter;

    ProgressDialog dialog;

    TopicViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("First Screen");

        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading please wait...");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        model = ViewModelProviders.of(this).get(TopicViewModel.class);

        loadData();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        if (bottomNavigationView != null) {
            bottomNavigationView.getMenu().getItem(0).setCheckable(true);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    item.setCheckable(true);
                    item.setChecked(true);
                    switch (item.getItemId()) {

                        case R.id.test2:
                            startActivity(new Intent(MainActivity.this, SecondActivity.class));
                            break;
                    }
                    return false;
                }
            });

        }

    }

    private void loadData() {

        model.getResponse().observe(this, new Observer<response>() {
            @Override
            public void onChanged(@Nullable response res) {

                List<topics> topic_list = res.getTopics();
                List<phrases> list = new ArrayList();
                HashMap hashMap = new HashMap();
                for (int i=0; i<topic_list.size();i++){
                    hashMap.put(topic_list.get(i).name,topic_list.get(i).getPhrases());
                    //list.addAll(topic_list.get(i).getPhrases());
                }

                adapter = new TopicAdapter(MainActivity.this, topic_list);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                dialog.dismiss();
            }
        });
    }
}
