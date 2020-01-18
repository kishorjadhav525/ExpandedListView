package com.example.expandedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyExpandableListAdapter listAdapter;


    ExpandableListView e;
    List<String> listDataHeader;
    HashMap<String, List<String>>listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the ListView
        e=findViewById(R.id.lvExp);
        //preparing list data
        prepareListData();

        listAdapter = new MyExpandableListAdapter(this,listDataHeader,listDataChild);
        e.setAdapter(listAdapter);
        e.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(MainActivity.this, "Group Cheked"+listDataHeader, Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        e.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, "Child Clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //Listview Group expanded listener
        e.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this, listDataHeader.get(groupPosition)+"Expanded", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void prepareListData() {

        listDataHeader= new ArrayList<>();
        listDataChild=new HashMap<>();

        //Adding Header Data
        listDataHeader.add("Lachaa");
        listDataHeader.add("Kachaa");
        listDataHeader.add("Bachaa");

        //Adding child data

        List<String>top250 =new ArrayList<String>();
        top250.add("Android");
        top250.add("Android Arch..");
        top250.add("Android SDk");
        top250.add("Android UI");
        top250.add("Android Notification");
        top250.add("Android Map");
        top250.add("Android Wi-Fi");
        top250.add("Android Blutooth");

        List<String>nowShowing=new ArrayList<String>();
        nowShowing.add("Android");
        nowShowing.add("Android Arch");
        nowShowing.add("Android SDK");
        nowShowing.add("Android UI");
        nowShowing.add("Android Notifiction");

        List<String>comingSoon=new ArrayList<String>();
        comingSoon.add("Android Map");
        comingSoon.add("Android Bluethooth");
        comingSoon.add("Android Wifi");


        listDataChild.put(listDataHeader.get(0),top250);//Hedadr Child data
        listDataChild.put(listDataHeader.get(1),nowShowing);
        listDataChild.put(listDataHeader.get(2),comingSoon);




    }

}