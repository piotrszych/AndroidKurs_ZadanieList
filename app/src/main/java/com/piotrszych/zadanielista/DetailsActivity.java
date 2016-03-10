package com.piotrszych.zadanielista;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        final LinearLayout circlesHolder = (LinearLayout) findViewById(R.id.details_circles_holder);

        pager.setAdapter(imagesPagerAdapter);
        titleTv.setText(mListObject.getHeroNameResId());
        String publisherText = getString(R.string.details_publisher_title, getString(mListObject.getPublisherResId()));
        publisherTv.setText(publisherText);
        detailsContentTv.setText(mListObject.getDescriptionResId());
        for(int i = 0; i < mListObject.getImagesResArray().length; i++) {
            View circleView = new View(this);
            LinearLayout.LayoutParams viewLP = new LinearLayout.LayoutParams(10, 10, 1);
            viewLP.setMargins(10, 10, 10, 10);
            circleView.setLayoutParams(viewLP);
            if(i == 0) circleView.setBackgroundResource(R.drawable.shape_circle_choosen);
            else circleView.setBackgroundResource(R.drawable.shape_circle_idle);
            circlesHolder.addView(circleView);
        }

        detailsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.this.finish();
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i < circlesHolder.getChildCount(); i++) {
                    if(i == position) circlesHolder.getChildAt(i).setBackgroundResource(R.drawable.shape_circle_choosen);
                    else circlesHolder.getChildAt(i).setBackgroundResource(R.drawable.shape_circle_idle);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
