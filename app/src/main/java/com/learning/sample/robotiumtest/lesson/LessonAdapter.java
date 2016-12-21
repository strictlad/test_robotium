package com.learning.sample.robotiumtest.lesson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


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
    public View getView(int position, View view, ViewGroup viewGroup) {
        View convertView = view;
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_lesson, viewGroup, false);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.item_lesson_title);
            holder.txtContent = (TextView) convertView.findViewById(R.id.item_lesson_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtTitle.setText(data.get(position).getTitle());
        holder.txtContent.setText(data.get(position).getContent());

        return convertView;
    }

    class ViewHolder {
        TextView txtTitle;
        TextView txtContent;
    }
}
