package com.openclassrooms.tourguide.DTO;

import gpsUtil.location.Location;
import java.util.ArrayList;


public class FiveNearestAttractionsDTO {
    public Location userLocation;
    public ArrayList<NearbyAttractionDTO> nearbyAttractions=new ArrayList<>();
}
