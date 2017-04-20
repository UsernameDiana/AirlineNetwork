/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportDomain;

/**
 *
 * @author diana
 */
public class Route {

    private Airline airline_code;
    private Airport source_code;
    private Airport destination_code;
    private double distance;
    private double time;

    public Route(Airline airline_code, Airport source_code, Airport destination_code, double distance, double time) {
        this.airline_code = airline_code;
        this.source_code = source_code;
        this.destination_code = destination_code;
        this.distance = distance;
        this.time = time;
    }

    public Airline getAirline_code() {
        return airline_code;
    }

    public void setAirline_code(Airline airline_code) {
        this.airline_code = airline_code;
    }

    public Airport getSource_code() {
        return source_code;
    }

    public void setSource_code(Airport source_code) {
        this.source_code = source_code;
    }

    public Airport getDestination_code() {
        return destination_code;
    }

    public void setDestination_code(Airport destination_code) {
        this.destination_code = destination_code;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    
    
}
