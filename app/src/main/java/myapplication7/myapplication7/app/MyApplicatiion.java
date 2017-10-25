package myapplication7.myapplication7.app;

import android.app.Application;

import com.bwie.imageloaderlibrary.UtilImage;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by Bare on 2017/10/25.
 */

public class MyApplicatiion extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = UtilImage.getConfiguration(this);
        ImageLoader.getInstance().init(configuration);
        //对xUtils进行初始化
        x.Ext.init(this);
    }
}
