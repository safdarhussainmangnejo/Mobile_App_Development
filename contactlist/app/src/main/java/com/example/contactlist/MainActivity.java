package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> ListofUsers = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserAdapter adapter = new UserAdapter(this, R.layout.contact_view, ListofUsers);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        User user1 = new User("Safdar", "safdar@gmail.com", "03352284313", 6);
        adapter.add(user1);
        User user2 = new User("Nazeer", "nazerahmed@gmail.com", "0335484313", 2);
        adapter.add(user2);
        User user3 = new User("Hasibullah", "hasib@gmail.com", "02352284313", 3);
        adapter.add(user3);
        User user4 = new User("Arslan Bhutto", "arslan@gmail.com", "03052284313", 4);
        adapter.add(user4);
        User user5 = new User("Ghafoor Bhutto", "ghafoor@gmail.com", "003243455546", 5);
        adapter.add(user5);
    }
}