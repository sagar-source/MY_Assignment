package com.example.myassignment.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myassignment.API.API;
import com.example.myassignment.Model.response;
import com.example.myassignment.RetrofitClient.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TopicViewModel extends ViewModel {

    private MutableLiveData<response> responseList;

    public LiveData<response> getResponse() {

        if (responseList == null) {
            responseList = new MutableLiveData<response>();

            loadResponse();
        }

        return responseList;
    }

    private void loadResponse() {

        Retrofit retrofit = RetrofitClient.getRetrofitClient();

        API api = retrofit.create(API.class);
        Call<response> call = api.getResponse();


        call.enqueue(new Callback<response>() {
            @Override
            public void onResponse(Call<response> call, Response<response> response) {

                responseList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<response> call, Throwable t) {

            }
        });
    }

}
