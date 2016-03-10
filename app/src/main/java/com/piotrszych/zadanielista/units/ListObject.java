package com.piotrszych.zadanielista.units;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListObject implements Parcelable{

    private Bitmap thumbnail;

    private Bitmap bmp01;
    private Bitmap bmp02;
    private Bitmap bmp03;

    @DrawableRes
    private int bmpRes01;
    @DrawableRes
    private int bmpRes02;
    @DrawableRes
    private int bmpRes03;

    @StringRes
    private int heroNameResId;
    @StringRes
    private int publisherResId;
    @StringRes
    private int descriptionResId;

    public ListObject(
            int[] imageResIds
            , @StringRes int heroNameRes
            , @StringRes int publisherRes
            , @StringRes int descriptionRes)
    {
        this.bmpRes01 = imageResIds[0];
        this.bmpRes02 = imageResIds[1];
        this.bmpRes03 = imageResIds[2];
        this.heroNameResId = heroNameRes;
        this.publisherResId = publisherRes;
        this.descriptionResId = descriptionRes;
    }

//    public Bitmap[] getImageBitmaps() {
//        return imageBitmaps;
//    }

    public Bitmap getTitleImage(Context context) {
        if(bmp01 == null) {
            bmp01 = BitmapFactory.decodeResource(context.getResources(), bmpRes01);
        }
        return bmp01;
    }

    public Bitmap getTitleImageThumbnail(Context context) {
        if(thumbnail == null) {
            thumbnail = ThumbnailUtils.extractThumbnail(getTitleImage(context), 100, 100);
        }
        return thumbnail;
    }

    @DrawableRes
    public int[] getImagesResArray() {
        return new int[]{bmpRes01, bmpRes02, bmpRes03};
    }

    @DrawableRes
    public int getTitleImageResId() {
        return bmpRes01;
    }

    public int getHeroNameResId() {
        return heroNameResId;
    }

    public int getPublisherResId() {
        return publisherResId;
    }

    public int getDescriptionResId() {
        return descriptionResId;
    }

    //parceling constructor
    public ListObject(Parcel in) {
        int[] data = new int[6];
        in.readIntArray(data);

        this.bmpRes01 = data[0];
        this.bmpRes02 = data[1];
        this.bmpRes03 = data[2];
        this.heroNameResId = data[3];
        this.publisherResId = data[4];
        this.descriptionResId = data[5];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(new int[]{
                this.bmpRes01
                , this.bmpRes02
                , this.bmpRes03
                , this.heroNameResId
                , this.publisherResId
                , this.descriptionResId});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public ListObject createFromParcel(Parcel in) {
            return new ListObject(in);
        }

        @Override
        public ListObject[] newArray(int size) {
            return new ListObject[size];
        }
    };
}
