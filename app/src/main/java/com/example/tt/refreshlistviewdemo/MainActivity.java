package com.example.tt.refreshlistviewdemo;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends ActionBarActivity {

    ListView  listView;
    ArrayList<String> arrayList = new ArrayList<String>();
    ItemAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i < 20; i++) {
            arrayList.add(i + " ");
        }
        listView = (ListView) findViewById(R.id.listView);
        itemAdapter = new ItemAdapter(MainActivity.this, R.layout.list_item, arrayList);
        listView.setAdapter(itemAdapter);

    }

    public class ItemAdapter extends ArrayAdapter<String> {
        ArrayList<String> arr;
        public ItemAdapter(Context context ,int textViewResourceId, ArrayList<String> obj) {
            super(context,  textViewResourceId, obj);
            this.arr = obj;

        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View v ;
            LayoutInflater inflater = getLayoutInflater();

           v = inflater.inflate(R.layout.list_item, parent, false);
            TextView txt = (TextView) v.findViewById(R.id.textView);
            Button btn = (Button) v.findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    arr.remove(position);
                    itemAdapter.notifyDataSetChanged();

                }
            });
            txt.setText("Position :  "+arr.get(position));
            return v;
        }
    }
}
