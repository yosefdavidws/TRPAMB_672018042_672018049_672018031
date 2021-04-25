package com.example.cryptotd_2;

import java.io.Serializable;

public class databasekoin implements Serializable {
    private String editTextbelibtc;
    //private String editTextbelieth;

    private String key;

    public databasekoin() {
    }

    public databasekoin(String editTextbelibtc) {
        this.editTextbelibtc = editTextbelibtc;

    }

    public String geteditTextbelibtc() {
        return editTextbelibtc;
    }

    public void editTextbelibtc(String editTextbelibtc) {
        this.editTextbelibtc = editTextbelibtc;
    }

    //public String getLongitude() {
    //    return editTextbelieth;
    //}

    //public void setLongitude(String longitude) {
     //   this.editTextbelieth = editTextbelieth;
    //}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "" +editTextbelibtc+"\n" ;
    }
}
