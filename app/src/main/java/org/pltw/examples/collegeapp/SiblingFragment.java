package org.pltw.examples.collegeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wdumas on 2/18/2015.
 */
public class SiblingFragment extends FamilyMemberFragment {
    private static final String TAG = "SiblingFragment";
    private static final String FILENAME = "Sibling.json";
    private Sibling mSibling;
    //    private GuardianJSONStorer mStorer;
    private Context mAppContext;

  /*  @Override
    public void onCreate(Bundle savedInstanceState) {
        mAppContext = this.getActivity();
        Log.d(TAG, "Context: " + mAppContext);
      mStorer = new GuardianJSONStorer(mAppContext, FILENAME);
        try {
            mGuardian = mStorer.load();
        } catch (Exception e) {
            mGuardian = new Guardian();
            Log.e(TAG, "Error loading guardian: " + FILENAME, e);
        }

    } */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_sibling, container, false);

        mSibling = (Sibling)Family.get().getFamily().get(getActivity().
                getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,1));

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        mEnterFirstName = (EditText)rootView.findViewById(R.id.enter_first_name);
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        mEnterLastName = (EditText)rootView.findViewById(R.id.enter_last_name);

        mFirstName.setText(mSibling.getFirstName());
        mLastName.setText(mSibling.getLastName());

        FirstNameTextChanger firstNameTextChanger = new FirstNameTextChanger();
        LastNameTextChanger lastNameTextChanger = new LastNameTextChanger();

        mEnterFirstName.addTextChangedListener(firstNameTextChanger);
        mEnterLastName.addTextChangedListener(lastNameTextChanger);

        return rootView;
    }

    private class FirstNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mSibling.setFirstName(s.toString());
            ArrayList family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,1);
            family.set(index, (FamilyMember) mSibling);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mSibling.getFirstName());
        }
    }

    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mSibling.setLastName(s.toString());
            ArrayList family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0);
            family.set(index, (FamilyMember)mSibling);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mSibling.getLastName());
        }
    }

    /*    private boolean saveGuardian() {
            try {
                mStorer.save(mGuardian);
                Log.d(TAG, "guardian saved to file.");
                return true;
            } catch (Exception e) {
                Log.e(TAG, "Error saving guardian: ", e);
                return false;
            }
        }
    */


    /*    private void loadGuardian() {
            try {
                mGuardian = mStorer.load();
                Log.d(TAG, "Loaded " + mGuardian.getFirstName());
                mFirstName.setText(mGuardian.getFirstName());
                mLastName.setText(mGuardian.getLastName());
            } catch (Exception e) {
                mGuardian = new Guardian();
                Log.e(TAG, "Error loading guardian from: " + FILENAME, e);
            }
        }
    */


}
