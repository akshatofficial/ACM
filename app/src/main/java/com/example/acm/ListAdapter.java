package com.example.acm;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ListAdapter extends BaseExpandableListAdapter {

    private Activity context;
    private Map<String, List<String>> ParentListItems;
    private List<String> Items;

    ListAdapter(Activity context,List<String> Items,Map<String,List<String>> ParentListItems)
    {
        this.context=context;
        this.Items=Items;
        this.ParentListItems=ParentListItems;
    }


    //Parent
    @Override
    public int getGroupCount() {
        return Items.size();
    }

    @Override
    public Object getGroup(int i) {
        return Items.get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String string = (String)getGroup(i);
        if(view==null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            view=layoutInflater.inflate(R.layout.menu_parent_item,null);
        }
        TextView item=view.findViewById(R.id.textParent);
        item.setText(string);
        return view;
    }

    //Child

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int getChildrenCount(int i) {
        return Objects.requireNonNull(ParentListItems.get(Items.get(i))).size();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Object getChild(int i, int i1) {
        return Objects.requireNonNull(ParentListItems.get(Items.get(i))).get(i1);
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childname = (String)getChild(i,i1);
        LayoutInflater inflater = context.getLayoutInflater();

        if(view==null)
            view=inflater.inflate(R.layout.menu_child_item,null);
        TextView item=view.findViewById(R.id.textChild);
        item.setText(childname);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
