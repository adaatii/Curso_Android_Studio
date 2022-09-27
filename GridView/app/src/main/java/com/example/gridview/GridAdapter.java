package com.example.gridview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> text;
    ArrayList<Integer> image;

    public GridAdapter(Context context, ArrayList<String> text, ArrayList<Integer> image) {
        this.context = context;
        this.text = text;
        this.image = image;
    }

    @Override
    public int getCount() {
        return text.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_layout,viewGroup,false);

        ImageView imageView = view.findViewById(R.id.imageView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = view.findViewById(R.id.tv_grid);

        textView.setText(text.get(position));
        imageView.setImageResource(image.get(position));

        return view;
    }
}
