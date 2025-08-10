
package com.example.airline.service;

public class FlightService {
    public boolean isSeatAvailable(String flightId) {
        return !"FL999".equals(flightId);
    }
}
