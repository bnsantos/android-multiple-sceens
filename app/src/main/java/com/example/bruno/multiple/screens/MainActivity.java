package com.example.bruno.multiple.screens;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.example.bruno.multiple.screens.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    setSupportActionBar(binding.myToolbar);

    binding.recyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.columns)));
    binding.recyclerView.setAdapter(new Adapter(getResources().getStringArray(R.array.urls)));
  }
}
