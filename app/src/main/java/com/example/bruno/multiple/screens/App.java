package com.example.bruno.multiple.screens;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by bruno on 10/05/16.
 */
public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Fresco.initialize(this);
  }
}
