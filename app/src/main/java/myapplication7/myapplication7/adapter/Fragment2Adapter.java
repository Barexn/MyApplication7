package myapplication7.myapplication7.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.imageloaderlibrary.UtilImage;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import myapplication7.myapplication7.R;
import myapplication7.myapplication7.bean.SecondBean;

/**
 * Created by Bare on 2017/10/25.
 */

public class Fragment2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<SecondBean.DataBean> list;

    public Fragment2Adapter(Context context, List<SecondBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item2,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        ImageLoader.getInstance().displayImage(list.get(position).getArticle_alt_url(),myViewHolder.imageView, UtilImage.getOptions());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item2_image);
        }
    }
}
