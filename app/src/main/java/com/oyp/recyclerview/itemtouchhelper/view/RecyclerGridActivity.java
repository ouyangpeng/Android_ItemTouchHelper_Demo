package com.oyp.recyclerview.itemtouchhelper.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.oyp.recyclerview.itemtouchhelper.R;
import com.oyp.recyclerview.itemtouchhelper.adapter.RecyclerListAdapter;
import com.oyp.recyclerview.itemtouchhelper.helper.OnStartDragListener;
import com.oyp.recyclerview.itemtouchhelper.helper.SimpleItemTouchHelperCallback;

/**
 * Created by OuyangPeng on 2017/6/26.
 */

public class RecyclerGridActivity extends AppCompatActivity  implements OnStartDragListener {
    RecyclerView mRecyclerView;

    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);

        int spanCount = getResources().getInteger(R.integer.grid_columns);
        GridLayoutManager layoutManager = new GridLayoutManager(this, spanCount);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerListAdapter adapter = new RecyclerListAdapter(this,this);
        mRecyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
