package com.example.david.watchcatalog.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.watchcatalog.R;
import com.example.david.watchcatalog.constants.WatchConstants;
import com.example.david.watchcatalog.db.SQLiteHelper;
import com.example.david.watchcatalog.models.WatchModel;
import com.example.david.watchcatalog.utils.AnimationUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WatchActivityInfoFragment extends Fragment {

    @Bind(R.id.watchesName) TextView name;
    @Bind(R.id.watchesPrice) TextView price;
    @Bind(R.id.watchesDescription) TextView description;

    private int bundle_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watch_info, container, false);
        ButterKnife.bind(this, view);
        initBundleVariable(getActivity().getIntent().getExtras());

        SQLiteHelper db = new SQLiteHelper(getActivity().getApplicationContext());
        WatchModel watch = db.getWatch(bundle_id);

        name.setText(watch.getName());
        price.setText(WatchConstants.MONEY_DOLLAR_SIGN + watch.getPrice());
        description.setText(watch.getDescription());

        initAnimations();

        return view;
    }

    private void initAnimations() {
        name.setAnimation(AnimationUtils.get_slide_up(this.getContext(), 900, 0));
        price.setAnimation(AnimationUtils.get_slide_up(this.getContext(), 1150, 0));
        description.setAnimation(AnimationUtils.get_slide_up(this.getContext(), 1350, 0));
    }

    private void initBundleVariable(Bundle bundle) {
        if (bundle != null) {
            bundle_id = bundle.getInt(WatchConstants.BUNDLE_WATCH_ID);
        } else {
            bundle_id = -1;
        }
    }
}
