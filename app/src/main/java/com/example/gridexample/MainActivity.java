package com.example.gridexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ArrayList<CastomNumber> data = creatureListNumber(50);
        // Настройка recyclerView
        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener((MyRecyclerViewAdapter.ItemClickListener) this);
        recyclerView.setAdapter(adapter);
    }

    //Создания листа чисел
    final ArrayList<CastomNumber> creatureListNumber(int quantity) {
        ArrayList<CastomNumber> data = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            CastomNumber castomNumber = new CastomNumber(i);
            data.add(castomNumber);
        }
        return data;
    }
    //Почему я не могу перегрузить метод из адаптера ?
    //Каким вообще способом я смогу обработать клик по обьекту из RecyclerView
    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }
}