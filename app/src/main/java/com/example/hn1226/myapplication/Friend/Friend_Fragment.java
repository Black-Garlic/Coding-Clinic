package com.example.hn1226.myapplication.Friend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hn1226.myapplication.Model.UserInfo;
import com.example.hn1226.myapplication.Network.GitHubService;
import com.example.hn1226.myapplication.Network.Repo;
import com.example.hn1226.myapplication.R;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Friend_Fragment extends Fragment {

    private RecyclerView mRecyclerView;
    private User_Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<UserInfo> userInfoArrayList = new ArrayList<>();

    public Friend_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        Call<List<Repo>> call = gitHubService.listUsers();

        final View view = inflater.inflate(R.layout.friend_fragment, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_user);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(0);
        mAdapter = new User_Adapter(userInfoArrayList, getActivity());

        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call,
                                   Response<List<Repo>> response) {
                for (int i = 0; i < response.body().size(); i++){
                    userInfoArrayList.add(new UserInfo(
                            response.body().get(i).getId(),
                            response.body().get(i).getName(),
                            response.body().get(i).getAvatarUrl(),
                            response.body().get(i).getUrl()
                    ));
                }
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            }
            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

        return view;
    }
}
