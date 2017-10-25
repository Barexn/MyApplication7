package myapplication7.myapplication7.presenter;

import myapplication7.myapplication7.fragment.Fragment1;
import myapplication7.myapplication7.model.Fragment1Model;
import myapplication7.myapplication7.model.Fragment1ModelListener;
import myapplication7.myapplication7.view.Fragment1View;

public class Fragment1Presenter {
    private Fragment1View fragment1View;
    private Fragment1Model fragment1Model;

    public Fragment1Presenter(Fragment1View fragment1View) {
        this.fragment1View = fragment1View;
        this.fragment1Model = new Fragment1Model();
    }

    public void getData(String path){
        fragment1Model.getData(path, new Fragment1ModelListener() {
            @Override
            public void success(Object object) {
                fragment1View.success(object);
            }
            @Override
            public void onfailed() {
                fragment1View.onfailed();
            }
        });
    }
}
