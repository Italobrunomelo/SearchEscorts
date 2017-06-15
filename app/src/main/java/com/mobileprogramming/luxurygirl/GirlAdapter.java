package com.mobileprogramming.luxurygirl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileprogramming.luxurygirl.model.Girls;

import java.util.ArrayList;

/**
 * Created by italo on 15/06/2017.
 */

public class GirlAdapter extends ArrayAdapter<Girls> {

    private final Context mContext;
    private final ArrayList<Girls> mListGirl;

    public GirlAdapter(Context mContext, ArrayList<Girls> mListGirl){
        super(mContext,R.layout.linha_list_view,mListGirl);

        this.mContext = mContext;
        this.mListGirl = mListGirl;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) mContext .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_list_view, parent, false);

        //ImageView imageViewList = (ImageView) rowView.findViewById(R.id.imageViewList);
        TextView textViewNameGirlList = (TextView) rowView.findViewById(R.id.textViewNameGirlList);
        TextView textViewAgeGirlList = (TextView) rowView.findViewById(R.id.textViewAgeGirlList);

        textViewNameGirlList.setText(mListGirl.get(position).getmName());
        textViewAgeGirlList.setText(mListGirl.get(position).getmAge());

        /*IMPLEMENTAR RETORNO DA FOTO*/
        //imageViewList.setText(mListGirl.get(position).get)

        return rowView;
    }
}
