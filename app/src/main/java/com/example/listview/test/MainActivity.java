package com.example.listview.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firsttest.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private String[] data={"apple","banana","orange","watermelon","pear","grape","pineapple","strawberry","cherry","mango",
//            "apple","banana","orange","watermelon","pear","grape","pineapple","strawberry","cherry","mango"};

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_listview_test);
        initFruits();  //初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits(){
        for(int i=0;i<2;i++){
            Fruit apple=new Fruit("apple",R.drawable.apple);
            fruitList.add(apple);
            Fruit banana=new Fruit("banana",R.drawable.banana);
            fruitList.add(banana);
            Fruit orange=new Fruit("orange",R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon=new Fruit("watermelon",R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear=new Fruit("pear",R.drawable.pear);
            fruitList.add(pear);
            Fruit grape=new Fruit("grape",R.drawable.grape);
            fruitList.add(grape);
            Fruit pineapple=new Fruit("pineapple",R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry=new Fruit("strawberry",R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit cherry=new Fruit("cherry",R.drawable.cherry);
            fruitList.add(cherry);
            Fruit mango=new Fruit("mango",R.drawable.mango);
            fruitList.add(mango);
        }
    }
}