package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyRecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyJuveAdapter adapter;
    private ArrayList<Players> playersArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler);
        String jsonData = "[{'name':'Cristiano Ronaldo', 'position': 'Forward', 'number': 7}," +
                "{'name': 'Leonardo Bonucci', 'position': 'Defender', 'number': 19}," +
                "{'name': 'Gianluigi Buffon', 'position': 'Goal keeper', 'number': 1}]";
        setData(jsonData);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new MyJuveAdapter(playersArrayList);
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(MyRecyclerActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    void setData(String jsonString){
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            playersArrayList = new ArrayList<>();
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Players player = new Players(jsonObject.getString("name"),
                        jsonObject.getString("position"),
                        jsonObject.getInt("number"));
                playersArrayList.add(player);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
