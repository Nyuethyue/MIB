package com.example.deadpool.mushroom;

/**
 * Created by plabm12 on 9/27/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<Model> modelList) {
        mContext = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the view in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        //set the results into textView
        holder.mTitleTv.setText(modelList.get(postition).getTitle());
        holder.mDescTv.setText(modelList.get(postition).getDesc());
        //set the result in ImageView
        holder.mIconIv.setImageResource(modelList.get(postition).getIcon());

        //ListView item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if (modelList.get(postition).getTitle().equals("Agaricus")){
                    //start Argricus activity and title for action bar
                    Intent intent = new Intent(mContext, OysterMushroom.class);
                    intent.putExtra("actionBarTitle", "Agaricus");
                    mContext.startActivity(intent);
                }
                if (modelList.get(postition).getTitle().equals("Chanterelle")){
                    //start Argricus activity and title for action bar
                    Intent intent = new Intent(mContext, OysterMushroom.class);
                    intent.putExtra("actionBarTitle", "Chanterelle");
                    mContext.startActivity(intent);
                }
                if (modelList.get(postition).getTitle().equals("Crimini")){
                    //start Argricus activity and title for action bar
                    Intent intent = new Intent(mContext, OysterMushroom.class);
                    intent.putExtra("actionBarTitle", "Crimini");
                    mContext.startActivity(intent);
                }
                if (modelList.get(postition).getTitle().equals("Shiitake")){
                    //start Argricus activity and title for action bar
                    Intent intent = new Intent(mContext, OysterMushroom.class);
                    intent.putExtra("actionBarTitle", "Shiitake");
                    mContext.startActivity(intent);
                }
                if (modelList.get(postition).getTitle().equals("Oyster")){
                    //start Argricus activity and title for action bar
                    Intent intent = new Intent(mContext, OysterMushroom.class);
                    intent.putExtra("actionBarTitle", "Oyster");
                    mContext.startActivity(intent);
                }
                if (modelList.get(postition).getTitle().equals("Enoki")){
                    //start Argricus activity and title for action bar
                    Intent intent = new Intent(mContext, OysterMushroom.class);
                    intent.putExtra("actionBarTitle", "Enoki");
                    mContext.startActivity(intent);
                }
                if (modelList.get(postition).getTitle().equals("Portabello")){
                    //start Argricus activity and title for action bar
                    Intent intent = new Intent(mContext, OysterMushroom.class);
                    intent.putExtra("actionBarTitle", "Portabello");
                    mContext.startActivity(intent);
                }
                if (modelList.get(postition).getTitle().equals("Porcini")){
                    //start Argricus activity and title for action bar
                    Intent intent = new Intent(mContext, OysterMushroom.class);
                    intent.putExtra("actionBarTitle", "Porcini");
                    mContext.startActivity(intent);
                }
                if (modelList.get(postition).getTitle().equals("Morel")){
                    //start Argricus activity and title for action bar
                    Intent intent = new Intent(mContext, OysterMushroom.class);
                    intent.putExtra("actionBarTitle", "Morel");
                    mContext.startActivity(intent);
                }
            }
        });


        return view;
    }
    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if (charText.length()==0){
            modelList.addAll(arrayList);
        }
        else{
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}

