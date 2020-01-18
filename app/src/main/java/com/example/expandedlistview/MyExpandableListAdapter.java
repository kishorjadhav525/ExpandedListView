package com.example.expandedlistview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

class MyExpandableListAdapter extends BaseExpandableListAdapter
{
     Context _context;
    List<String> _listdataHeader;  //header titles
    //child data in format of header title , child title
    HashMap<String, List<String>> _listChildData;

    public MyExpandableListAdapter(Context _context, List<String> _listdataHeader, HashMap<String, List<String>> _listChildData) {
        this._context = _context;
        this._listdataHeader = _listdataHeader;
        this._listChildData = _listChildData;
    }

    @Override
    public int getGroupCount() {
        return this._listdataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listChildData.get(this._listdataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listdataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listChildData.get(this._listdataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle =(String) getGroup(groupPosition);
        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater)this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader =(TextView) convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface( null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childtext =(String) getChild(groupPosition,childPosition);

        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater)this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_group_c, null);
        }

        TextView lblListHeader_c =(TextView) convertView.findViewById(R.id.lblListHeader_c);
        lblListHeader_c.setTypeface( null, Typeface.BOLD);
        lblListHeader_c.setText(childtext);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
