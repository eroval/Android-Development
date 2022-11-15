package com.example.earthquake;

/**
 * An {@link EarthquakeModel} object contains information related to a single earthquake.
 */
public class EarthquakeModel {

    /** Magnitude of the earthquake */
    private String mMagnitude;

    /** Location of the earthquake */
    private String mLocation;

    /** Date of the earthquake */
    private String mDate;

    /** Coordinates of the earthquake */
    private String mCoordinates;



    /**
     * Constructs a new {@link EarthquakeModel} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the location where the earthquake happened
     * @param date is the date when the earthquake happened
     */
    public EarthquakeModel(String magnitude, String location, String date, String coordinates) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mCoordinates = coordinates;
    }

    /**
     * Returns the magnitude of the earthquake.
     */
    public String getMagnitude() {
        return mMagnitude;
    }

    /**
     * Returns the location of the earthquake.
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Returns the date of the earthquake.
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Returns the coordinates of the earthquake.
     */
    public String getCoordinates() {
        return mCoordinates;
    }
}