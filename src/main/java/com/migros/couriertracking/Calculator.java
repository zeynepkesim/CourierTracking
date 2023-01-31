package com.migros.couriertracking;

public class Calculator {

    //Calculates the distance in meters between two coordinates.
    public static double calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        if ((lat1 == lat2) && (lng1 == lng2)) {
            return 0;
        } else {
            double earthRadius = 6371000; //meters
            double distanceLat = Math.toRadians(lat2 - lat1);
            double distanceLng = Math.toRadians(lng2 - lng1);
            double a = Math.sin(distanceLat / 2) * Math.sin(distanceLat / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                    Math.sin(distanceLng / 2) * Math.sin(distanceLng / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = earthRadius * c;

            return distance;
        }
    }

    //Calculates the time by the distance and the speed.
    public static double calculateTime(double distance, double speed) {
        return distance / speed;
    }

}