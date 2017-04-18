/**
 * Created by Jianhan on 4/15/17.
 */
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jgraph.graph.Edge;
import org.jgrapht.*;
import org.jgrapht.graph.*;

public class HW8 {
    static WeightedGraph<String, DefaultWeightedEdge> wg =
            new WeightedMultigraph<>(DefaultWeightedEdge.class);
    static int vertices = 0;
    static int edges = 0;

    public static boolean isInteger(String s) {
        if(s.matches(".*\\d.*")){
            return true;
        } else{
            return false;
        }
    }

    public static void storeData() {
        try {
            BufferedReader read = new BufferedReader(new FileReader("miles.dat"));
            String contains;
            List <String> cities = new ArrayList<>();

            int i;
            int k = 0;

            while ((contains = read.readLine()) != null) {
                String result[] = contains.split(",");

                if(!isInteger(result[0])){
                    cities.add(result[0]);
                    wg.addVertex(result[0]);
                    System.out.println(result[0]);
                    k = 0;
                    vertices++;
                }
                else{
                    String distance[] = contains.split(" ");
                    double miles[] = new double[distance.length];

                    for(int j = 0; j < distance.length; j++) {
                        if(Double.parseDouble(distance[j]) != 0){
                            miles[j] = Double.parseDouble(distance[j]);
                        }
                    }

                    for(i = 0; i < miles.length; i++){
                        System.out.println("  k" + k +"  city: " + cities.size());
                        wg.addEdge(cities.get(cities.size() - 1), cities.get(k));
                        wg.setEdgeWeight(wg.getEdge(cities.get(cities.size() - 1), cities.get(k)), miles[i]);
                        System.out.println(" " + wg.getEdgeWeight(wg.getEdge(cities.get(cities.size() - 1), cities.get(k))));
                        k++;
                        edges++;
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public static void Boruvkas(WeightedGraph G, int n, int m){
        List<Edge> mst = new ArrayList<>();
        for(int i = 1; i < n && mst.size() < n - 1; i = i + i){
        }
    }
    public static void main(String[] args) {
        storeData();

    }
}
