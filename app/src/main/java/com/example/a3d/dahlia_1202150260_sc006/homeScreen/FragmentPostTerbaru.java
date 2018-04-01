package com.example.a3d.dahlia_1202150260_sc006.homeScreen;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3d.dahlia_1202150260_sc006.MainActivity;
import com.example.a3d.dahlia_1202150260_sc006.R;
import com.example.a3d.dahlia_1202150260_sc006.adapter.AdapterPost;
import com.example.a3d.dahlia_1202150260_sc006.model.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by 3D on 4/1/2018.
 */

public class FragmentPostTerbaru extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    ProgressDialog mProgressDialog;

    private ArrayList<Post> listPosts;
    //our database reference object
    Query databaseFood;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_post_terbaru, container, false);

        databaseFood = FirebaseDatabase.getInstance().getReference( MainActivity.table1).orderByChild("timestamp");


        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setTitle("Loading Data");
        mProgressDialog.setMessage("Please wait....");
        mProgressDialog.show();

        recyclerView = view.findViewById(R.id.recyclerView);

        listPosts = new ArrayList<>();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart(); //attaching value event listener
        databaseFood.addValueEventListener(new ValueEventListener () {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                listPosts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Post post = postSnapshot.getValue(Post.class);

                    listPosts.add(post);
                }
                recyclerView.setHasFixedSize(true);

                recyclerView.setLayoutManager(new GridLayoutManager (getContext(), 2));

                AdapterPost postList = new AdapterPost(getContext(), listPosts);

                recyclerView.setAdapter(postList);
                mProgressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                mProgressDialog.dismiss();
            }
        });
    }
}
