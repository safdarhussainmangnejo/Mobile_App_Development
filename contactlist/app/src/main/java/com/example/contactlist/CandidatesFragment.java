package com.example.contactlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CandidatesFragment extends Fragment {



    public CandidatesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CandidatesFragment newInstance(String param1, String param2) {
        CandidatesFragment fragment = new CandidatesFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_candidates, container, false);
    }
}