package com.oyp.recyclerview.itemtouchhelper.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.oyp.recyclerview.itemtouchhelper.R;
import com.oyp.recyclerview.itemtouchhelper.adapter.ChannelAdapter;
import com.oyp.recyclerview.itemtouchhelper.helper.ChannelItemDragHelperCallback;
import com.oyp.recyclerview.itemtouchhelper.model.ChannelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 频道 拖拽排序、增删
 *
 * 在普通模式下，长按“我的频道”的item，可以拖拽排序并进入编辑模式
 *
 * 在编辑模式下，触摸“我的频道”的item，可以直接拖拽排序
 *
 * 在任意模式下，点击“其他频道”的item，移动到“我的频道”，并伴随移动动画
 *
 * 在编辑模式下，点击“我的频道”的item，移动到“其他频道”，并伴随移动动画
 */
public class ChannelActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        init();
    }

    private void init() {
        final List<ChannelEntity> items = new ArrayList<>();
        for (int i = 1; i <= 18; i++) {
            ChannelEntity entity = new ChannelEntity();
            entity.setName("频道" + i);
            items.add(entity);
        }
        final List<ChannelEntity> otherItems = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            ChannelEntity entity = new ChannelEntity();
            entity.setName("其他" + i);
            otherItems.add(entity);
        }

        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);

        ChannelItemDragHelperCallback callback = new ChannelItemDragHelperCallback();
        final ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecyclerView);

        final ChannelAdapter adapter = new ChannelAdapter(this, helper, items, otherItems);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == ChannelAdapter.TYPE_MY_CHANNEL || viewType == ChannelAdapter.TYPE_OTHER_CHANNEL ? 1 : 4;
            }
        });
        mRecyclerView.setAdapter(adapter);

        adapter.setOnMyChannelItemClickListener(new ChannelAdapter.OnMyChannelItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(ChannelActivity.this, items.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
