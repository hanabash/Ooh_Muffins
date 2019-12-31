package com.example.oohmuffins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import adapters.adapterWeeklyMuffins;
import setup.pics.plus.text.cardviewData;

public class displayMuffinCollection extends AppCompatActivity {

    private final String muffin_names[] = {
            "Snowflakes",
            "Strawberry Cheesecake",
            "Red Velvet",
            "Vanilla and Cranberry Swirl",
            "Cherry Chocolate Almond",
            "Blueberry Banana Bundle",
    };

    private final String muffin_image_urls[] = {
            "https://cdn.pixabay.com/photo/2017/12/11/06/21/christmas-dinner-3011500_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/05/28/02/21/strawberry-2349943_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/10/17/23/30/cupcake-2862439_960_720.jpg",
            "https://cdn.pixabay.com/photo/2019/04/22/00/14/cupcakes-4145306_960_720.jpg",
            "https://cdn.pixabay.com/photo/2015/06/18/01/21/dessert-813277_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/04/14/20/15/muffins-1329679_960_720.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_muffin_collection);
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutmanager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerview.setLayoutManager(layoutmanager);

        ArrayList<cardviewData> all_cardview_data = prepareData();
        adapterWeeklyMuffins adapter = new adapterWeeklyMuffins(getApplicationContext(), all_cardview_data);
        recyclerview.setAdapter(adapter);
    }

    private ArrayList<cardviewData> prepareData() {
        ArrayList<cardviewData> all_data = new ArrayList<>();
        for (int i = 0; i < muffin_names.length; i++) {
            cardviewData data = new cardviewData();
            data.setMuffin_name(muffin_names[i]);
            data.setMuffin_image_url(muffin_image_urls[i]);
            all_data.add(data);
        }
        return all_data;
    }

}
