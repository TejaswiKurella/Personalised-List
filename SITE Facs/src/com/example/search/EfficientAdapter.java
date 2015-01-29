package com.example.search;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.sitefacs.R;

public class EfficientAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    ViewHolder holder;

    static class ViewHolder {
        TextView text1;
        TextView text2;
    }
    
    public EfficientAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return CountriesList.abbreviations.length;
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
            convertView = mInflater.inflate(R.layout.row, null);
            holder = new ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            holder.text2 = (TextView) convertView
                    .findViewById(R.id.TextView02);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text1.setText(CountriesList.countries[position]);
        holder.text2.setText(CountriesList.abbreviations[position]);
        
        if(position % 2 ==1)
        {
        convertView.setBackgroundColor(Color.rgb(231, 249, 255));
        }
        else
        {
        convertView.setBackgroundColor(Color.rgb(200, 240, 255)); 
        }


        return convertView;
    }

}
