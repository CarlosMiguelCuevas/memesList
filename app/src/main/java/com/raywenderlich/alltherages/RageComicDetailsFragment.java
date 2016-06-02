package com.raywenderlich.alltherages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RageComicDetailsFragment extends Fragment {

    public static RageComicDetailsFragment newInstance() {
        return new RageComicDetailsFragment();
    }

    public RageComicDetailsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rage_comic_details, container, false);
    }
}