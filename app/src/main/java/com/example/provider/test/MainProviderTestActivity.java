package com.example.provider.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.firsttest.R;

public class MainProviderTestActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainProviderTestActivit";

    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_provider_test);
        Button addData = (Button) findViewById(R.id.add_data);
        Button queryData = (Button) findViewById(R.id.query_data);
        Button updateData = (Button) findViewById(R.id.update_data);
        Button deleteData = (Button) findViewById(R.id.delete_data);
        addData.setOnClickListener(this);
        queryData.setOnClickListener(this);
        updateData.setOnClickListener(this);
        deleteData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_data:
                Uri uri = Uri.parse("content://com.example.Database.test.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "A Clash of Kings");
                values.put("author", "George Martin");
                values.put("pages", 1040);
                values.put("price", 22.85);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
                break;
            case R.id.query_data:
                Uri uri1 = Uri.parse("content://com.example.Database.test.provider/book");
                Cursor cursor = getContentResolver().query(uri1, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d(TAG, "book name is" + name);
                        Log.d(TAG, "book author is" + author);
                        Log.d(TAG, "book pages is" + pages);
                        Log.d(TAG, "book price is" + price);
                    }
                    cursor.close();
                }
                break;
            case R.id.update_data:
                Uri uri2 = Uri.parse("content://com.example.Database.test.provider/book" + newId);
                ContentValues values1 = new ContentValues();
                values1.put("name", "A Storm of Swords");
                values1.put("pages", 1216);
                values1.put("price", 24.05);
                getContentResolver().update(uri2, values1, null, null);
                break;
            case R.id.delete_data:
                Uri uri3 = Uri.parse("content://com.example.Database.test.provider/book" + newId);
                getContentResolver().delete(uri3, null, null);
                break;
            default:
                break;
        }

    }
}