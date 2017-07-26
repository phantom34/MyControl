package com.example.administrator.mycontrol.weight;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by phantom on 2017/7/14.
 */


public class CustomPopWindow {

    private PopupWindow popupWindow;
    private View ContentView;
    private Context mContext;

    public CustomPopWindow(Builder builder) {
        this.mContext = builder.context;
        ContentView = LayoutInflater.from(mContext).inflate(builder.contentviewid, null);
        popupWindow = new PopupWindow(ContentView, builder.width, builder.height, builder.fouse);
        popupWindow.setOutsideTouchable(builder.outsidecancer);
        popupWindow.setFocusable(builder.fouse);
        popupWindow.setAnimationStyle(builder.animstyle);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }


    /**
     * PopUpWindows.dismiss()
     */
    public void dismiss() {
        if (null != popupWindow)
            popupWindow.dismiss();
    }

    public View getItemView(int viewid) {
        if (null != popupWindow)
            return this.ContentView.findViewById(viewid);
        else return null;
    }

    public CustomPopWindow showAtLocation(int rootviewid, int gravity, int x, int y) {

        if (null != popupWindow) {
            View mView = LayoutInflater.from(mContext).inflate(rootviewid, null);
            popupWindow.showAtLocation(mView, gravity, x, y);

        }
        return this;
    }

    public CustomPopWindow showAsLocation(int rootviewid, int gravity, int x, int y) {
        if (null != popupWindow) {
            View mView = LayoutInflater.from(mContext).inflate(rootviewid, null);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                popupWindow.showAsDropDown(mView, gravity, x, y);
            }
        }
        return this;
    }

    public CustomPopWindow showAtlocation(View rootView, int gravity, int x, int y) {
        if (null != popupWindow)
            popupWindow.showAtLocation(rootView, gravity, x, y);
        return this;
    }

    /**
     * 设置 焦点监听
     * @param viewid
     * @param listener
     */
    public void setOnFocuseListener(int viewid, View.OnFocusChangeListener listener) {
        View mView = getItemView(viewid);
        mView.setOnFocusChangeListener(listener);
    }

    public static class Builder {
        private int contentviewid;
        private int width;
        private int height;
        private boolean fouse;
        private Context context;
        private boolean outsidecancer;
        private int animstyle;

        public Builder setContentviewid(int contentviewid) {
            this.contentviewid = contentviewid;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setFouse(boolean fouse) {
            this.fouse = fouse;
            return this;
        }

        public Builder setOutsidecancer(boolean outsidecancer) {
            this.outsidecancer = outsidecancer;
            return this;
        }

        public Builder setAnimstyle(int animstyle) {
            this.animstyle = animstyle;
            return this;
        }


        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public CustomPopWindow builder() {
            return new CustomPopWindow(this);
        }
    }

}
