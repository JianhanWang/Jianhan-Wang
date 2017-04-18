/**
 * Created by Jianhan on 4/15/17.
 */
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.*;
import org.jgrapht.graph.*;

public class HW8 {
    public static WeightedGraph<String, DefaultWeightedEdge> wg =
            new WeightedMultigraph<>(DefaultWeightedEdge.class);

    static int edge = 0;

    public static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static void storeData() {
        try {
            BufferedReader read = new BufferedReader(new FileReader("miles.dat"));
            String contains;
            List <String> cities = new ArrayList<>();

            int i;
            int num = 0;

            while ((contains = read.readLine()) != null) {
                String result[] = contains.split(",");

                if(!isNumeric(result[0])){
                    cities.add(result[0]);
                    wg.addVertex(result[0]);
                    num = 0;
                }
                else {
                    String distance[] = contains.split(" ");
                    double miles[] = new double[distance.length];

                    for(int j = 0; j < distance.length; j++) {
                        miles[j] = Double.parseDouble(distance[j]);
                    }

                    for(i = num; i < cities.size();i++){
                        wg.addEdge(cities.get(cities.size()-1), cities.get(i));
                        wg.setEdgeWeight(wg.getEdge(cities.get(cities.size()-1), cities.get(i)), miles[i]);
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        storeData();
        System.out.println(edge);
    }
}
