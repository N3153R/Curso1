package com.example.n3153r.curso1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by N3153R on 20/09/2016.
 */
public class FrutasVerdurasAdapter extends ArrayAdapter<FrutasVerduras> {
    Context MyContext;
    int MyLayoutResourceID;
    FrutasVerduras MyData[] = null;

    public FrutasVerdurasAdapter(Context context, int layoutResourceID, FrutasVerduras[] data){
        super(context, layoutResourceID,data);
        this.MyContext = context;
        this.MyLayoutResourceID = layoutResourceID;
        this.MyData = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        FrutasVerdurasHolder holder = null;

        if(row==null){
            LayoutInflater inflater = ((Activity)MyContext).getLayoutInflater();

            row = inflater.inflate(MyLayoutResourceID,parent,false);

            holder = new FrutasVerdurasHolder();
            holder.imagen=(ImageView)row.findViewById(R.id.image);
            holder.textView=(TextView)row.findViewById(R.id.tv);
            row.setTag(holder);

        }else {
            holder = (FrutasVerdurasHolder)row.getTag();
        }
        FrutasVerduras frutasVerduras = MyData[position];
        holder.textView.setText(frutasVerduras.title);
        holder.imagen.setImageResource(frutasVerduras.icon);

        return null;
    }

    static class  FrutasVerdurasHolder{
        ImageView imagen;
        TextView textView;
    }
}
