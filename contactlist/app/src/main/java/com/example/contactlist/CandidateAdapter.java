package com.example.contactlist;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CandidateAdapter extends ArrayAdapter<CandidatesNames> {

    Context context;
    int resource;
    ArrayList<CandidatesNames> candidates;
    public CandidateAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CandidatesNames> candidates) {
        super(context, resource, candidates);
        this.context = context;
        this.resource = resource;
        this.candidates = candidates;
    }
}
