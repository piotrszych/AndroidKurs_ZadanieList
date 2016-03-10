package com.piotrszych.zadanielista.units;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImagesPagerAdapter extends PagerAdapter {

    private static final String TAG = "ImagesPagerAdapter";

    private int[] mImageResList;
    private Context mContext;

    public ImagesPagerAdapter(Context context, @DrawableRes int[] images) {
        Log.d(TAG, "Initializing pager adapter");
        mContext = context;
        mImageResList = new int[images.length];
        //deep copy
        System.arraycopy(images, 0, mImageResList, 0, images.length);
    }

    @Override
    public int getCount() {
        return mImageResList.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "creating item on position " + position + " with resId " + mImageResList[position]);
        ImageView imageView = new ImageView(mContext);
        ViewGroup.LayoutParams ivLayoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(ivLayoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        //load image in safe way, safe way, safe way~
        //Picasso.with(mContext).load(mImageResList[position]).into(imageView);
        imageView.setImageResource(mImageResList[position]);
        ((ViewPager) container).addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
