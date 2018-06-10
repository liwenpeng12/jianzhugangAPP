package com.jlkg.jzg.jzg_android.other.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jlkg.jzg.baselibrary.weidget.GlideApp;
import com.jlkg.jzg.jzg_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {


    private int type;

    public ImageFragment() {
        // Required empty public constructor
    }

    public static ImageFragment getInstance(int type) {
        ImageFragment imageFragment = new ImageFragment();
        imageFragment.type = type;
        return imageFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = getView().findViewById(R.id.img_page);
        if (type == 0)
            GlideApp.with(getActivity()).load(R.mipmap.guide_1).into(imageView);
        else if (type == 1)
            GlideApp.with(getActivity()).load(R.mipmap.guide_2).into(imageView);
    }
}
