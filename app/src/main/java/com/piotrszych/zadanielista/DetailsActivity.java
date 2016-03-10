package com.piotrszych.zadanielista;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.piotrszych.zadanielista.units.ImagesPagerAdapter;
import com.piotrszych.zadanielista.units.ListObject;

public class DetailsActivity extends AppCompatActivity {

    private ListObject mListObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mListObject = getIntent().getExtras().getParcelable(getString(R.string.extra_list_object));

        ViewPager pager = (ViewPager) findViewById(R.id.details_image_pager);
        ImagesPagerAdapter imagesPagerAdapter = new ImagesPagerAdapter(this, mListObject.getImagesResArray());
        TextView titleTv = (TextView) findViewById(R.id.details_title);
        TextView publisherTv = (TextView) findViewById(R.id.details_publisher);
        TextView detailsContentTv = (TextView) findViewById(R.id.details_details_content);
        RelativeLayout detailsBackButton = (RelativeLayout) findViewById(R.id.details_back_button);

        pager.setAdapter(imagesPagerAdapter);
        titleTv.setText(mListObject.getHeroNameResId());
        String publisherText = getString(R.string.details_publisher_title, getString(mListObject.getPublisherResId()));
        publisherTv.setText(publisherText);
        detailsContentTv.setText(mListObject.getDescriptionResId());

        detailsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.this.finish();
            }
        });
    }
}
