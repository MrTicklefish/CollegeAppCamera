package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wdumas on 8/16/2015.
 */
public class Sibling extends FamilyMember {

    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        return json;
    }

    public String toString() {
        return "Sibling: " + mFirstName + " " + mLastName;
    }

    public Sibling(){
        setFirstName("Malina");
        setLastName("Dumas");
        setRelation(super.SIBLING);
    }

    public Sibling(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public Sibling(JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mLastName = json.getString(JSON_LAST_NAME);
    }
}
