package com.example.slava.simplezoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mSpinner;
    private ListView mListView;
    private ArrayAdapter<String> mArrayAdapter;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
    }

    private void findViews() {
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mListView = (ListView) findViewById(R.id.list_view);
        mImageView = (ImageView) findViewById(R.id.imageView);
    }

    private void setListeners() {
        mSpinner.setOnItemSelectedListener(this);

        mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1
                , getResources().getStringArray(R.array.list_insects));
        mListView.setAdapter(mArrayAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                mImageView.setImageResource(getImageResource(textView.getText().toString()));
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0 :
                mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1
                        , getResources().getStringArray(R.array.list_insects));
                mListView.setAdapter(mArrayAdapter);

                break;

            case 1 :
                mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1
                        , getResources().getStringArray(R.array.list_arthropods));
                mListView.setAdapter(mArrayAdapter);
                break;

            case 2 :
                mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1
                        , getResources().getStringArray(R.array.list_birds));
                mListView.setAdapter(mArrayAdapter);
                break;

            case 3 :
                mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1
                        , getResources().getStringArray(R.array.list_animals));
                mListView.setAdapter(mArrayAdapter);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private int getImageResource(String name){
        return getResources().getIdentifier(name.toLowerCase(), "drawable", this.getPackageName());
    }
}
