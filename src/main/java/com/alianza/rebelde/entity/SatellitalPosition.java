package com.alianza.rebelde.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SatellitalPosition {

    private List<Satellites> satellites;

    public List<Satellites> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellites> satellites) {
        this.satellites = satellites;
    }

    public double[] getDistances(){
        double [] distances = new double[satellites.size()];
        for(int i = 0; i < satellites.size(); i ++){
            distances[i] = satellites.get(i).getDistance();
        }
        return distances;
    }

    public double[][] getPositions(){
        double [][] positions = new double[satellites.size()][];
        String[] points;
        for(int i = 0; i < satellites.size(); i ++){
            if(satellites.get(i).getPosition() != null) {
                points = satellites.get(i).getPosition().toString().split(",");
                positions[i] = Arrays.stream(points)
                        .map(Double::valueOf)
                        .mapToDouble(Double::doubleValue)
                        .toArray();
            }
        }
        return positions;
    }

    public void setPositions(double[][] pointsList){
        Position position;
        for(int i = 0; i < pointsList.length; i++){
            position = new Position(pointsList[i]);
            satellites.get(i).setPosition(position);
        }
    }

    public List<List<String>> getMessages(){
        List<List<String>> message = new ArrayList<List<String>>();
        for(Satellites satellite : satellites){
            message.add(satellite.getMessage());
        }
        return message;
    }

}
