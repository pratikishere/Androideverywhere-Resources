package com.dragswipewithrecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.dragswipewithrecyclerview.R;
import com.dragswipewithrecyclerview.adapter.RecyclerViewAdapter;
import com.dragswipewithrecyclerview.dragndrop.OnStartDragListener;
import com.dragswipewithrecyclerview.dragndrop.SimpleItemTouchHelperCallback;
import com.dragswipewithrecyclerview.model.ItemData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnStartDragListener,RecyclerViewAdapter.ICallback {

    private ArrayList<ItemData> itemDatas = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private RecyclerView rvItems;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        initRecyclerView();
    }

    private void initRecyclerView(){
        rvItems = (RecyclerView)findViewById(R.id.rvItems);
        rvItems.setHasFixedSize(true);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        setAdapter();

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(this,adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(rvItems);
    }

    private void fillData(){
        itemDatas.clear();
        for (int i = 0; i < 25; i++) {
            ItemData itemData = new ItemData();
            itemData.setItemId(String.valueOf(i));
            itemData.setItemName("Item "+String.valueOf(i));
            itemDatas.add(itemData);
        }
    }

    private void setAdapter(){
        adapter = new RecyclerViewAdapter(this, this,itemDatas,this);
        rvItems.setAdapter(adapter);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
        mItemTouchHelper.startSwipe(viewHolder);
    }

    @Override
    public void onItemRemove(int position) {
        Toast.makeText(this,"Item "+position+" is removed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemUndo(int position) {
        Toast.makeText(this,"Item "+position+" is undo",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemPositionChange(int fromPosition, int toPosition) {
        Toast.makeText(this,"Item is moved from "+fromPosition+" to "+toPosition,Toast.LENGTH_LONG).show();
    }
}
