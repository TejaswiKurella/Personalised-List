package com.example.search;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.sitefacs.R;

public class MyFacsAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    ViewHolder holder;

    static class ViewHolder {
        TextView text1;
        TextView text2;
        TextView text3;
    }
    
    public MyFacsAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return MyFacsList.name.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    /*public ViewHolder GetItemAtPosition(int position)
    {
        return holder[position];
    }*/

    public View getView(int position, View convertView, ViewGroup parent) {
        
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.myfacs_row, null);
            holder = new ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            holder.text2 = (TextView) convertView
                    .findViewById(R.id.TextView02);
            holder.text3 = (TextView) convertView
                    .findViewById(R.id.TextView03);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        //String [] nameArray = MyFacsList.name.toArray(new String[MyFacsList.name.size()]);
        //String [] locArray = MyFacsList.loc.toArray(new String[MyFacsList.loc.size()]);

        holder.text1.setText(MyFacsList.name.get(position));
        holder.text2.setText(MyFacsList.loc.get(position));
        holder.text3.setText(MyFacsList.email.get(position));
        
        if(position % 2 ==1)
        {
        convertView.setBackgroundColor(Color.rgb(250, 250, 250));
        }
        else
        {
        convertView.setBackgroundColor(Color.rgb(230, 230, 230)); 
        }

        return convertView;
    }

}
