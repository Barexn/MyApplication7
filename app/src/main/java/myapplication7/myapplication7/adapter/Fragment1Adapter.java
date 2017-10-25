package myapplication7.myapplication7.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.imageloaderlibrary.UtilImage;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import myapplication7.myapplication7.R;
import myapplication7.myapplication7.bean.ShouyeBean;

/**
 * Created by Bare on 2017/10/25.
 */

public class Fragment1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<ShouyeBean.DataBean> list;

    public Fragment1Adapter(Context context, List<ShouyeBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.ativity_item,null);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            MyHolder myHolder= (MyHolder) holder;
            ImageLoader.getInstance().displayImage(list.get(position).getArticle_alt_url(),myHolder.imageView, UtilImage.getOptions());
            myHolder.tv1.setText(list.get(position).getArticle_sub_type()+"");
            myHolder.tv2.setText(list.get(position).getAbstractX());
            myHolder.tv3.setText(list.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item1_image);
            tv1 = itemView.findViewById(R.id.item1_tv1);
            tv2 = itemView.findViewById(R.id.item1_tv2);
            tv3 = itemView.findViewById(R.id.item1_tv3);
        }
    }
}
