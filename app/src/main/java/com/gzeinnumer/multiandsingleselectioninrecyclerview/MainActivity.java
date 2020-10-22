package com.gzeinnumer.multiandsingleselectioninrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectableViewHolder.OnItemSelectedListener {

    RecyclerView recyclerView;
    SelectableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) this.findViewById(R.id.selection_list);
        recyclerView.setLayoutManager(layoutManager);
        List<Item> selectableItems = generateItems();
        adapter = new SelectableAdapter(this,selectableItems,true);
        recyclerView.setAdapter(adapter);
    }

    public List<Item> generateItems(){

        List<Item> selectableItems = new ArrayList<>();
        selectableItems.add(new Item("cem","karaca"));
        selectableItems.add(new Item("sezen","aksu"));
        selectableItems.add(new Item("baris","manco"));

        return selectableItems;
    }

    @Override
    public void onItemSelected(SelectableItem selectableItem) {

        List<Item> selectedItems = adapter.getSelectedItems();
        Snackbar.make(recyclerView,"Selected item is "+selectableItem.getName()+
                ", Totally  selectem item count is "+selectedItems.size(),Snackbar.LENGTH_LONG).show();
    }
}