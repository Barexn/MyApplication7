package myapplication7.myapplication7.presenter;

import myapplication7.myapplication7.model.Fragment1ModelListener;
import myapplication7.myapplication7.model.Fragment2Model;
import myapplication7.myapplication7.model.Fragment2ModelListener;
import myapplication7.myapplication7.view.Fragment2View;

public class Fragment2Presenter {
    private Fragment2Model model;
    private Fragment2View view;

    public Fragment2Presenter( Fragment2View view) {
        this.model = new Fragment2Model();
        this.view = view;
    }

    public void getData(String path){
        model.getData(path, new Fragment2ModelListener() {
            @Override
            public void success(Object object) {
                view.success(object);
            }
            @Override
            public void onfailed() {
                view.onfailed();
            }
        });
    }

}
