package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by wdumas on 2/11/2015.
 */
public class Guardian extends FamilyMember implements ApplicantData {
    private String mOccupation;
    private static final String JSON_OCCUPATION = "occupation";
    private static final String DEFAULT_OCCUPATION = "unknown";

    public Guardian(){
        setFirstName("Roger");
        setLastName("Dumas");
        setOccupation("Market Forecaster");
        setRelation(super.GUARDIAN);
    }

    public Guardian(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setOccupation(DEFAULT_OCCUPATION);
    }

    public Guardian(String firstName, String lastName, String occupation) {
        setFirstName(firstName);
        setLastName(lastName);
        setOccupation(occupation);
    }

    public Guardian(JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mLastName = json.getString(JSON_LAST_NAME);
        mOccupation = json.getString(JSON_OCCUPATION);
    }

    public String getOccupation() {
        return mOccupation;
    }

    public void setOccupation(String occupation) {
        mOccupation = occupation;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        json.put(JSON_OCCUPATION, getOccupation());
        return json;
    }

    public String toString () {
        return "Guardian: " + mFirstName + " " + mLastName + "\nOccupation: " + mOccupation;
    }
}
