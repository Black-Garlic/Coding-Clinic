package com.example.hn1226.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        Call<List<Repo>> call = gitHubService.repoContributors("square", "retrofit");
        final View view = inflater.inflate(R.layout.mainfragment, container, false);
        final TextView textView1 = (TextView) view.findViewById(R.id.userView);
        final TextView textView2 = (TextView) view.findViewById(R.id.contView);

        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call,
                                   Response<List<Repo>> response) {
                textView1.setText("User");
                textView2.setText("Contribution");
                for (int i = 0; i < response.body().size(); i++){
                    textView1.append(response.body().get(i).getUser());
                    textView2.append(response.body().get(i).getContribution());
                }
            }
            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
        return view;
    }

}
