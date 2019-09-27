package com.introvd.template.starvlogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p021v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class CommonFragment extends Fragment {
    private String imageUrl;
    private ImageView imageView;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(ToolsUtils.getIdLayout(getActivity(), "item_viewpager"), null);
        this.imageView = (ImageView) rootView.findViewById(ToolsUtils.findViewId(getActivity(), "image"));
        ImageLoader.getInstance().displayImage(this.imageUrl, this.imageView);
        return rootView;
    }

    public void bindData(String imageUrl2) {
        this.imageUrl = imageUrl2;
    }
}
