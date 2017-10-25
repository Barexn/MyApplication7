package myapplication7.myapplication7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bare on 2017/10/25.
 */

public class XiangqingActivity extends AppCompatActivity {
    @BindView(R.id.xiangqing_recycler)
    RecyclerView xiangqingRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        ButterKnife.bind(this);
    }

}
