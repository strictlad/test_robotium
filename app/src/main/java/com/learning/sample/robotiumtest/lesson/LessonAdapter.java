package com.learning.sample.robotiumtest.lesson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.learning.sample.robotiumtest.R;

import java.util.ArrayList;

/**
 * Created by Duc on 12/20/2016.
 */

public class LessonAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Lesson> data;
    private LayoutInflater inflater;

    public LessonAdapter(Context context, ArrayList<Lesson> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        View convertView = view;
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_lesson, viewGroup, false);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.item_lesson_title);
            holder.txtContent = (TextView) convertView.findViewById(R.id.item_lesson_content);
            holder.btn1 = (Button) convertView.findViewById(R.id.btn1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtTitle.setText(data.get(position).getTitle());
        holder.txtContent.setText(data.get(position).getContent());
        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Click to btn in item: " + (position+1), Toast.LENGTH_LONG).show();
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Start with " + data.get(position).getContent(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    class ViewHolder {
        TextView txtTitle;
        TextView txtContent;
        Button btn1;
    }
}
