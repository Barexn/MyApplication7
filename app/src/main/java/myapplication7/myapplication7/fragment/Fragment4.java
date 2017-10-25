package myapplication7.myapplication7.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.List;

import myapplication7.myapplication7.R;
import myapplication7.myapplication7.adapter.Fragment1Adapter;
import myapplication7.myapplication7.adapter.Fragment2Adapter;
import myapplication7.myapplication7.bean.SecondBean;
import myapplication7.myapplication7.bean.ShouyeBean;
import myapplication7.myapplication7.presenter.Fragment2Presenter;
import myapplication7.myapplication7.view.Fragment2View;

public class Fragment4 extends Fragment implements Fragment2View{

    private RecyclerView recyclerView;
    private String path="http://ic.snssdk.com/2/article/v25/stream/?category=news_health&count=20&bd_city=%E5%8C%97%E4%BA%AC%E5%B8%82&bd_latitude=40.049317&bd_longitude=116.296499&bd_loc_time=1455524092&loc_mode=5&lac=4527&cid=28883&iid=3642583580&device_id=11131669133&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=SCH-I919U&os_api=19&os_version=4.4.2&uuid=285592931621751&openudid=AC9E172CE2490000";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment4,null);
        recyclerView = view.findViewById(R.id.fr4_recycler);
        Fragment2Presenter presenter=new Fragment2Presenter(this);
        presenter.getData(path);
        return view;
    }

    @Override
    public void success(final Object object) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson=new Gson();
                SecondBean bean=gson.fromJson(object.toString(),SecondBean.class);
                List<SecondBean.DataBean> list=bean.getData();

                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                Fragment2Adapter adapter=new Fragment2Adapter(getActivity(),list);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onfailed() {

    }
}
