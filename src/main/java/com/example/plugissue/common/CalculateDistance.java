package com.example.plugissue.common;

public class CalculateDistance {
    private static final double EARTH_RADIUS = 6371.0;
    public static double calculateDistance(double s_lat, double s_lng, double u_lat, double u_lng){
        double dLat = Math.toRadians((u_lat - s_lat));
        double dLng = Math.toRadians((u_lng - s_lng));

        double a = Math.sin(dLat/2) * Math.sin(dLat/2)
                + Math.cos(Math.toRadians(s_lat)) * Math.cos(Math.toRadians(u_lat))
                * Math.sin(dLng/2) * Math.sin(dLng/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}
