
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mluney
 */
public class JobGraph {
    List<List<String>> graphList = new ArrayList<>();
    
    private ArrayList <Integer> nodes;
    private ArrayList< LinkedList< Integer > > connections;
    public JobGraph(){
        nodes = new ArrayList<>();
        connections = new ArrayList<>();
    }//constructor for emptyGraph
}
