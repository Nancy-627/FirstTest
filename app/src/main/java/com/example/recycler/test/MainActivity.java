package com.example.recycler.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.firsttest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recyclerview_test);
        initFruits(); //初始化水果数据
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for(int i=0;i<2;i++){
            com.example.recycler.test.Fruit apple=new com.example.recycler.test.Fruit(getRandomLengthName("apple"),R.drawable.apple);
            fruitList.add(apple);
            com.example.recycler.test.Fruit banana=new com.example.recycler.test.Fruit(getRandomLengthName("banana"),R.drawable.banana);
            fruitList.add(banana);
            com.example.recycler.test.Fruit orange=new com.example.recycler.test.Fruit(getRandomLengthName("orange"),R.drawable.orange);
            fruitList.add(orange);
            com.example.recycler.test.Fruit watermelon=new com.example.recycler.test.Fruit(getRandomLengthName("watermelon"),R.drawable.watermelon);
            fruitList.add(watermelon);
            com.example.recycler.test.Fruit pear=new com.example.recycler.test.Fruit(getRandomLengthName("pear"),R.drawable.pear);
            fruitList.add(pear);
            com.example.recycler.test.Fruit grape=new com.example.recycler.test.Fruit(getRandomLengthName("grape"),R.drawable.grape);
            fruitList.add(grape);
            com.example.recycler.test.Fruit pineapple=new com.example.recycler.test.Fruit(getRandomLengthName("pineapple"),R.drawable.pineapple);
            fruitList.add(pineapple);
            com.example.recycler.test.Fruit strawberry=new com.example.recycler.test.Fruit(getRandomLengthName("strawberry"),R.drawable.strawberry);
            fruitList.add(strawberry);
            com.example.recycler.test.Fruit cherry=new com.example.recycler.test.Fruit(getRandomLengthName("cherry"),R.drawable.cherry);
            fruitList.add(cherry);
            com.example.recycler.test.Fruit mango=new com.example.recycler.test.Fruit(getRandomLengthName("mango"),R.drawable.mango);
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}