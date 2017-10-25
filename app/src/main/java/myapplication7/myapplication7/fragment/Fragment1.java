package myapplication7.myapplication7.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.liaoinstan.springview.container.AcFunFooter;
import com.liaoinstan.springview.container.AcFunHeader;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.widget.SpringView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import myapplication7.myapplication7.R;
import myapplication7.myapplication7.adapter.Fragment1Adapter;
import myapplication7.myapplication7.banner.ImageLoaderBanner;

import myapplication7.myapplication7.bean.ShouyeBean;
import myapplication7.myapplication7.presenter.Fragment1Presenter;
import myapplication7.myapplication7.view.Fragment1View;


public class Fragment1 extends Fragment implements Fragment1View {


    private Banner banner;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout springView;
    private String img1 = "http://img95.699pic.com/photo/50047/0111.jpg_wh300.jpg";
    private String img2 = "http://img95.699pic.com/photo/50039/0266.jpg_wh300.jpg!/format/webp";
    private String img3 = "http://img95.699pic.com/photo/50032/0608.jpg_wh300.jpg!/format/webp";
    private String img4 = "http://img95.699pic.com/photo/50048/2213.jpg_wh300.jpg!/format/webp";
    private String path="http://ic.snssdk.com/2/article/v25/stream/?category=news_hot&count=20&min_behot_time=1455521166&bd_city=%E5%8C%97%E4%BA%AC%E5%B8%82&bd_latitude=40.049317&bd_longitude=116.296499&bd_loc_time=1455521401&loc_mode=5&lac=4527&cid=28883&iid=3642583580&device_id=11131669133&ac=wifi&channel=baidu&aid=13&app_nme=news_article&version_code=460&device_platform=android&device_type=SCH-I919U&os_api=19&os_version=4.4.2&uuid=285592931621751&openudid=AC9E172CE2490000";
    private Fragment1Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_fragment1,null);
        banner = view.findViewById(R.id.banner);
        recyclerView = view.findViewById(R.id.fr1_rec);
        springView = view.findViewById(R.id.fr1_spring);
        presenter = new Fragment1Presenter(this);
        presenter.getData(path);
        banner();
        return view;
    }

    public void banner(){
        banner.setImageLoader(new ImageLoaderBanner());
        List<String> list=new ArrayList<>();
        list.add(img1);
        list.add(img2);
        list.add(img3);
        list.add(img4);
        banner.setImages(list);
        banner.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void success(final Object object) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson=new Gson();
                ShouyeBean bean=gson.fromJson(object.toString(),ShouyeBean.class);
                List<ShouyeBean.DataBean> list=bean.getData();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(linearLayoutManager);
                Fragment1Adapter adapter=new Fragment1Adapter(getActivity(),list);
                recyclerView.setAdapter(adapter);
                springView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        presenter.getData(path);
                        springView.setRefreshing(false);
                        Toast.makeText(getActivity(), "上拉加载~", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onfailed() {

    }
}
