package myapplication7.myapplication7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import myapplication7.myapplication7.view.MyAnimView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAnimView mv = (MyAnimView) findViewById(R.id.mv);

        mv.setSetJumpListener(new MyAnimView.SetJumpListener() {
            @Override
            public void setListener() {
                Intent intent = new Intent(MainActivity.this, SeconActivity.class);
                startActivity(intent);
            }
        });
    }
}
