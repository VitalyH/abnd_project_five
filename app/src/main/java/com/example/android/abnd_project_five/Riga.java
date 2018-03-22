package com.example.android.abnd_project_five;

/**
 * Riga contains information about a city venues.
 */

public class Riga {

    /**
     * Venue title.
     */
    private String mVenueTitle;

    /**
     * Working Hours.
     */
    private String mWorkingHours;

    /**
     * Link to the web-site with additional info.
     */
    private String mRigaWeb;
    /**
     * Image of the venue.
     */
    private int mVenueImage;

    /**
     * Create a new Riga object for fragments.
     *
     * @param venueTitle  is the title of the venue.
     * @param workingHours is the working hours.
     * @param rigaWeb  is the web-site address.
     * @param venueImage is the image of the venue.
     */
    public Riga(String venueTitle, String workingHours, String rigaWeb, int venueImage) {
        mVenueTitle = venueTitle;
        mWorkingHours = workingHours;
        mRigaWeb = rigaWeb;
        mVenueImage = venueImage;
    }


    /**
     * Get the venue title.
     */
    public String getVenueTitle() {
        return mVenueTitle;
    }

    /**
     * Get the working hours.
     */
    public String getWorkingHours() {
        return mWorkingHours;
    }

    /**
     * Get the web-address.
     */

    public String getRigaWeb() {
        return mRigaWeb;
    }

    /**
     * Get the venue image.
     */

    public int getVenueImage() {
        return mVenueImage;
    }

}
