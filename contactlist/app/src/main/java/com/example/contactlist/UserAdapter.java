package com.example.contactlist;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {

    Context context;
    int resource;
    ArrayList<User> users;

    public UserAdapter(Context context, int resource, ArrayList<User> users){
        super(context, resource, users);
        this.context = context;
        this.resource = resource;
        this.users = users;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        User user = this.users.get(position);

        TextView name = convertView.findViewById(R.id.name);
        TextView email = convertView.findViewById(R.id.email);
        TextView number = convertView.findViewById(R.id.number);
        ImageView image = convertView.findViewById(R.id.profile);

        name.setText(user.name);
        email.setText(user.email);
        number.setText(user.number);
        image.setImageResource(R.drawable.person+user.imageId);

        return convertView;
    }
}

