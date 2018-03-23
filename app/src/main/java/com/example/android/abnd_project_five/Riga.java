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
     * Price range.
     */
    private String mPriceRange = NO_PRICE_RANGE_PROVIDED;

    /**
     * Price range field check.
     */
    private static final String NO_PRICE_RANGE_PROVIDED = "null";

    /**
     * Create a new Riga object for fragment TopSights, With Kids.
     *
     * @param venueTitle   is the title of the venue.
     * @param workingHours is the working hours.
     * @param rigaWeb      is the web-site address.
     * @param venueImage   is the image of the venue.
     */
    public Riga(String venueTitle, String workingHours, String rigaWeb, int venueImage) {
        mVenueTitle = venueTitle;
        mWorkingHours = workingHours;
        mRigaWeb = rigaWeb;
        mVenueImage = venueImage;
    }

    /**
     * Create a new Riga object for fragments Wine&Dine, Bars&Clubs.
     *
     * @param venueTitle   is the title of the venue.
     * @param workingHours is the working hours.
     * @param rigaWeb      is the web-site address.
     * @param venueImage   is the image of the venue.
     * @param priceRange   is the image of the venue.
     */
    public Riga(String venueTitle, String workingHours, String priceRange, String rigaWeb, int venueImage) {
        mVenueTitle = venueTitle;
        mWorkingHours = workingHours;
        mRigaWeb = rigaWeb;
        mPriceRange = priceRange;
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
     * Get the photo of venue.
     */
    public int getVenueImage() {
        return mVenueImage;
    }

    /**
     * Get the price range.
     */
    public String getPriceRange() {
        return mPriceRange;
    }

    /**
     * Returns whether or not there is price range field.
     */
    public boolean hasPriceRange() {
        return !mPriceRange.equals(NO_PRICE_RANGE_PROVIDED);
    }


}
