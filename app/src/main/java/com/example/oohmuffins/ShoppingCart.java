package com.example.oohmuffins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.ShoppingCartAdapter;
import item_decorations.DividerItemDecoration;
import item_decorations.VerticalSpaceItemDecoration;

public class ShoppingCart extends AppCompatActivity implements ShoppingCartAdapter.ItemClickListener {

    ShoppingCartAdapter adapter;
    private final String TAG = "Shopping Cart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        ArrayList<String> muffinList = new ArrayList<>();
        muffinList.add("Strawberry Cheesecake");
        muffinList.add("Birthday Pop");
        muffinList.add("Mocha");

        muffinList.add("Another muffin");
        muffinList.add("Supercalifragilisticexpialidocious muffin");
        muffinList.add("Muffin named after Benedict Cumberbatch");
        muffinList.add("Hmm I thought the Benedict Cumberbatch Muffin name would be shorter than the one before that");
        muffinList.add("But I guess not");
        muffinList.add("Oh well");
        muffinList.add("Still need to fill this");
        muffinList.add("So here goes");
        muffinList.add("Fa la la la la la la la la");
        muffinList.add("Ooh Christmas themed muffins <3");
        muffinList.add("What would I name them");
        muffinList.add("Candy Cane Muffin");
        muffinList.add("Should probably have some punny names too");
        muffinList.add("Totally fits my personality");
        muffinList.add("On second thought");
        muffinList.add("Probably not");
        muffinList.add("This is making me hungry");
        muffinList.add("Hungryyyy");
        muffinList.add("Sleepyyyy");
        muffinList.add("Ahh finally");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShoppingCartAdapter(this, muffinList);
        adapter.setClickListener(this);

        // Item Decoration -- Vertical Space
        final int VERTICAL_ITEM_SPACE = 48; // needed for vertical space item decoration
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));

        /** Item Decoration -- Divider (default Android divider attributes)
         recyclerView.addItemDecoration(new DividerItemDecoration(this));
         **/

        /** Item Decoration -- Divider (custom based on my own drawable) **/
        recyclerView.addItemDecoration(new DividerItemDecoration(this, R.drawable.divider));

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You selected " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "This is info.");
    }

}
