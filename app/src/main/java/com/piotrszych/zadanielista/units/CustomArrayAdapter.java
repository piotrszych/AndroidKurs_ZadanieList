package com.piotrszych.zadanielista.units;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.piotrszych.zadanielista.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<ListObject>{
    //save context to be used for getting inflater
    private Context mContext;
    //save our objects so we know on what we operate
    private List<ListObject> mObjects;

    public CustomArrayAdapter(Context context, List<ListObject> objects) {
        super(context, R.layout.list_item, objects);
        this.mContext = context;
        this.mObjects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ListObject object = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView image = (ImageView) row.findViewById(R.id.list_item_image);
        TextView title = (TextView) row.findViewById(R.id.list_item_title);
        TextView subtitle = (TextView) row.findViewById(R.id.list_item_subtitle);

        object = mObjects.get(position);
        //Bitmap bm = BitmapFactory.decodeResource(mContext.getResources(), object.getTitleImageResId());
        //Bitmap bm = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeResource(mContext.getResources(), object.getTitleImageResId()), 100, 100);
        //image.setImageResource(object.getTitleImageResId());
        //image.setImageBitmap(bm);
        Picasso.with(mContext).load(object.getTitleImageResId()).into(image);
        //image.setImageBitmap(object.getTitleImageThumbnail(mContext));
        title.setText(object.getHeroNameResId());
        subtitle.setText(object.getPublisherResId());

        row.setTag(object);
        return row;
    }
}
