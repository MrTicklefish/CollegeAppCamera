package org.pltw.examples.collegeapp;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by PLTW on 1/25/2016.
 */
public class FamilyMemberFragment extends Fragment {

    private String TAG = "FamilyMemberFragment";
    protected TextView mFirstName;
    protected EditText mEnterFirstName;
    protected TextView mLastName;
    protected EditText mEnterLastName;

    @Override
    public void onPause() {
        super.onPause();
        //  saveGuardian();
        Log.d(TAG, "Fragment paused.");
    }

    @Override
    public void onResume() {
        super.onResume();
        //    loadGuardian();
        Log.d(TAG, "Fragment resumed.");
    }

}
