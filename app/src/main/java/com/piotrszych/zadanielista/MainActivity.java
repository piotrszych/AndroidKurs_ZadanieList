package com.piotrszych.zadanielista;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.piotrszych.zadanielista.units.CustomArrayAdapter;
import com.piotrszych.zadanielista.units.ListObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = (ListView) findViewById(R.id.main_list);
        CustomArrayAdapter caa = new CustomArrayAdapter(this, getDummyList());
        mListView.setAdapter(caa);

        //add listener
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListObject object = (ListObject) view.getTag();
                Intent transitionIntent = new Intent(MainActivity.this, DetailsActivity.class);
                transitionIntent.putExtra(getString(R.string.extra_list_object), object);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        MainActivity.this
                        , new Pair<>(view.findViewById(R.id.list_item_image), getString(R.string.transition_image))
                        , new Pair<>(view.findViewById(R.id.list_item_title), getString(R.string.transition_title))
                );
                ActivityCompat.startActivity(MainActivity.this, transitionIntent, optionsCompat.toBundle());
            }
        });
    }

    private ArrayList<ListObject> getDummyList() {
        ArrayList<ListObject> toReturn = new ArrayList<>();
        //FIXME
        int[] imgs_batman = new int[]{R.drawable.batman_01, R.drawable.batman_01, R.drawable.batman_01};
        //FIXME
        int[] imgs_laika = new int[]{R.drawable.laika_01, R.drawable.laika_01, R.drawable.laika_01};
        //FIXME
        int[] imgs_superman = new int[]{R.drawable.superman_01, R.drawable.superman_01, R.drawable.superman_01};
        //FIXME
        int[] imgs_spiderman = new int[]{R.drawable.spiderman_01, R.drawable.spiderman_01, R.drawable.spiderman_01};
        //FIXME
        int[] imgs_punisher = new int[]{R.drawable.punisher_01, R.drawable.punisher_01, R.drawable.punisher_01};
        //FIXME
        int[] imgs_sandman = new int[]{R.drawable.sandman_01, R.drawable.sandman_01, R.drawable.sandman_01};
        //FIXME
        int[] imgs_wonderwoman = new int[]{R.drawable.wonderwoman_01, R.drawable.wonderwoman_01, R.drawable.wonderwoman_01};
        //FIXME
        int[] imgs_manhattan = new int[]{R.drawable.manhattan_01, R.drawable.manhattan_01, R.drawable.manhattan_01};
        int[] imgs_canary = new int[]{R.drawable.blackcanary_01, R.drawable.blackcanary_02, R.drawable.blackcanary_03};
        int[] imgs_ironman = new int[]{R.drawable.ironman_01, R.drawable.ironman_02, R.drawable.ironman_03};
        int[] imgs_lantern = new int[]{R.drawable.lantern_01, R.drawable.lantern_02, R.drawable.lantern_03};
        int[] imgs_deadpool = new int[]{R.drawable.deadpool_01, R.drawable.deadpool_02, R.drawable.deadpool_03};
        int[] imgs_arrow = new int[]{R.drawable.greenarrow_01, R.drawable.greenarrow_02, R.drawable.greenarrow_03};

        toReturn.add(new ListObject(imgs_batman, R.string.list_item_name_batman, R.string.list_item_publisher_dc, R.string.list_item_description_batman));
        toReturn.add(new ListObject(imgs_laika, R.string.list_item_name_laika, R.string.list_item_publisher_image, R.string.list_item_description_laika));
        toReturn.add(new ListObject(imgs_superman, R.string.list_item_name_superman, R.string.list_item_publisher_dc, R.string.list_item_description_superman));
        toReturn.add(new ListObject(imgs_spiderman, R.string.list_item_name_spiderman, R.string.list_item_publisher_marvel, R.string.list_item_description_spiderman));
        toReturn.add(new ListObject(imgs_punisher, R.string.list_item_name_punisher, R.string.list_item_publisher_marvel, R.string.list_item_description_punisher));
        toReturn.add(new ListObject(imgs_sandman, R.string.list_item_name_sandman, R.string.list_item_publisher_vertigo, R.string.list_item_description_sandman));
        toReturn.add(new ListObject(imgs_wonderwoman, R.string.list_item_name_wonderwoman, R.string.list_item_publisher_dc, R.string.list_item_description_wonderwoman));
        toReturn.add(new ListObject(imgs_manhattan, R.string.list_item_name_drmanhattan, R.string.list_item_publisher_dc, R.string.list_item_description_drmanhattan));
        toReturn.add(new ListObject(imgs_canary, R.string.list_item_name_black_canary, R.string.list_item_publisher_dc, R.string.list_item_description_black_canary));
        toReturn.add(new ListObject(imgs_ironman, R.string.list_item_name_iron_man, R.string.list_item_publisher_marvel, R.string.list_item_description_iron_man));
        toReturn.add(new ListObject(imgs_lantern, R.string.list_item_name_green_lantern, R.string.list_item_publisher_dc, R.string.list_item_description_green_lantern));
        toReturn.add(new ListObject(imgs_deadpool, R.string.list_item_name_deadpool, R.string.list_item_publisher_marvel, R.string.list_item_description_deadpool));
        toReturn.add(new ListObject(imgs_arrow, R.string.list_item_name_green_arrow, R.string.list_item_publisher_dc, R.string.list_item_description_green_arrow));

        return toReturn;
    }
}
