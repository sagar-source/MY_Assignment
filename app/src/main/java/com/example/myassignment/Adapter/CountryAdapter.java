package com.example.myassignment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myassignment.Model.country;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myassignment.R;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    Context mCtx;
    List<country> countryList;
    String val;

    public CountryAdapter(Context mCtx, List<country> countryList) {
        this.mCtx = mCtx;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.country_row, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CountryViewHolder holder, final int position) {

        val = countryList.get(position).name;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    val+="a";
                    holder.text_country_name.setText(val);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        }).start();

        /*Timer timer = new Timer();
        timer.scheduleAtFixedRate( new TimerTask() {
            public void run() {
                val+="a";
                holder.text_country_name.setText(val);
                //notifyDataSetChanged();
            }
        }, 0, 1000);*/

       /* Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               try {
                   val+="a";
                   holder.text_country_name.setText(val);
                   notifyDataSetChanged();
               }catch (Exception e){
                 e.printStackTrace();
               }
            }
        },1000);*/

        holder.text_country_time.setText(countryList.get(position).time);

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }


    class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView text_country_name;
        TextView text_country_time;

        public CountryViewHolder(View itemView) {
            super(itemView);

            text_country_name = itemView.findViewById(R.id.txt_country);
            text_country_time = itemView.findViewById(R.id.txt_time);
        }
    }
}
