package com.bawei.banner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list;
    private Banner banner;
    private String img1 = "http://img95.699pic.com/photo/50047/0111.jpg_wh300.jpg";
    private String img2 = "http://img95.699pic.com/photo/50039/0266.jpg_wh300.jpg!/format/webp";
    private String img3 = "http://img95.699pic.com/photo/50032/0608.jpg_wh300.jpg!/format/webp";
    private String img4 = "http://img95.699pic.com/photo/50048/2213.jpg_wh300.jpg!/format/webp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = (Banner) findViewById(R.id.myBanner);
        getBanner();
    }

    private void getBanner() {
        banner.setImageLoader(new ImageLoaderBanner());
        list = new ArrayList<String>();
        list.add(img1);
        list.add(img2);
        list.add(img3);
        list.add(img4);
        banner.setImages(list);
        banner.start();
    }
}
