package com.dreamscode.loginapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.dreamscode.loginapplication.adapters.AdapterClass;
import com.dreamscode.loginapplication.models.ModelClass;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AdapterClass.ViewHolder.RecyclerViewClickListener {
    RecyclerView rv_lists;
    AdapterClass adapterClass;
    ArrayList<ModelClass> modelClasses;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rv_lists = findViewById(R.id.rv_list);
        initData();
        setAdapter();
    }

    private void setAdapter() {
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        adapterClass = new AdapterClass(modelClasses,ListActivity.this::onClickListner);
        rv_lists.setAdapter(adapterClass);
        rv_lists.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        //get data from database
        modelClasses = new ArrayList<>();
        modelClasses.add(new ModelClass(R.drawable.student2,"A S R Perera","Colombo"));
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Sunil","Galle"));
        modelClasses.add(new ModelClass(R.drawable.student2,"A S R Amal","Kandy"));
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Silva","Negambo"));
        modelClasses.add(new ModelClass(R.drawable.student2,"A S R Shantha","Matara"));
        modelClasses.add(new ModelClass(R.drawable.student2,"A S R Perera","Matara"));
        modelClasses.add(new ModelClass(R.drawable.student2,"A S R Perera","Matara"));
    }

    @Override
    public Void onClickListner(int position) {
        String name = modelClasses.get(position).getName();
        Toast.makeText(ListActivity.this, "hello "+name, Toast.LENGTH_SHORT).show();
        return null;
    }
}