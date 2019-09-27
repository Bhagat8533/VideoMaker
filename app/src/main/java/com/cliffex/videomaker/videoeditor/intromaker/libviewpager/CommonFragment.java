package com.cliffex.videomaker.videoeditor.intromaker.libviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CommonFragment extends Fragment {
    private int imageUrl;
    private ImageView imageView;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getResources().getIdentifier("fragment_common", "layout", getActivity().getPackageName()), null);
        this.imageView = (ImageView) rootView.findViewById(getResources().getIdentifier("image", "id", getActivity().getPackageName()));
        this.imageView.setImageResource(this.imageUrl);
        return rootView;
    }

    public void bindData(int imageUrl2) {
        this.imageUrl = imageUrl2;
    }
}
