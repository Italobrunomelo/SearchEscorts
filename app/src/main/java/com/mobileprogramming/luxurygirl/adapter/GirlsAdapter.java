package com.mobileprogramming.luxurygirl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileprogramming.luxurygirl.R;
import com.mobileprogramming.luxurygirl.model.Girls;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by italo on 06/06/2017.
 */

public class GirlsAdapter  extends BaseAdapter{

    Context mContext;
    List<Girls> mListGirls;

    public GirlsAdapter(Context mContext,List<Girls> mListGirls){
        this.mContext = mContext;
        this.mListGirls = mListGirls;
    }

    @Override
    public int getCount() {
        return mListGirls.size();
    }

    @Override
    public Object getItem(int position) {
        return mListGirls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //POSIÇÃO DO OBJETO NA LISTA
        Girls mGirl = mListGirls.get(position);

        //CARREGAR ACTIVITY DA LISTA
        View mRowList = LayoutInflater.from(mContext).inflate(R.layout.fragment_girls_list, null);
        View mGirlInformation = LayoutInflater.from(mContext).inflate(R.layout.fragment_girls_informations, null);

        //COMPONENTES VISUAIS DA LISTVIEW
        ImageView mPhoto = (ImageView) mRowList.findViewById(R.id.imageViewPhoto);

        ImageView mPhotoInformation = (ImageView) mGirlInformation.findViewById(R.id.imageViewPhoto);
        TextView mName = (TextView) mGirlInformation.findViewById(R.id.textViewNameInformation);
        TextView mAge = (TextView) mGirlInformation.findViewById(R.id.textViewLabelAge);
        TextView mInformation = (TextView) mGirlInformation.findViewById(R.id.textViewInformationInformation);
        TextView mLocation = (TextView) mGirlInformation.findViewById(R.id.textViewLabelLocation);
        TextView mContact = (TextView) mGirlInformation.findViewById(R.id.textViewLabelContact);

        return null;
    }
}
