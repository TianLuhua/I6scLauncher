package com.boyue.boyuelauncher.main.fragment.fragment1;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by Tianluhua on 2018/5/18.
 */
public class Fragment_1_PersenterImp extends Fragment_1_Persenter {

    private Context mContext;
    private Fragment_1_Mode fragment_1_mode;


    public Fragment_1_PersenterImp( Context mContext) {
        this.mContext=mContext;
        this.fragment_1_mode=new Fragment_1_Mode(mContext, new Fragment_1_Mode.CallBack() {
            @Override
            public void getIcon(Drawable iconDrawble) {
                Fragment_1_View view=getView();
                if (view!=null){
                    view.displayIocn(iconDrawble);
                }
            }
        });
    }


    @Override
    public void getIconDrawble() {
        if (fragment_1_mode!=null)
            fragment_1_mode.getIconDrawble();
    }
}
