/*
 * filename: DirectedGraph.java
 * author: roland carter
 * date: 2018-12-15
 * purpose: DirectedGraph class performs a depth first search on a 
 *          graph of class dependencies then provides the order of classes
*/

package classdepgraphgui;

// import libraries
import java.util.*;
import java.io.*;

// begin DirectedGraph class
public class DirectedGraph<T> {
    // define variables
    private Map<T, Integer> mapInt;
    private ArrayList<LinkedList<Integer>> edgesList;
    private List<Integer> graphNeighbors;
    private StringBuilder outputText;
    
    private int numVertices = 0;
    
    // constructor
    DirectedGraph(){
        mapInt = new HashMap<>();
        edgesList = new ArrayList<>();
    }
    
    // method depthFirstSearch performs a depth-first search algorithm
    private void depthFirstSearch(int v) throws CatchErrors {
        // append className to output string
        outputText.append(indexToName(v)).append(" ");
        
        // iterate through each int in edgesList
        for (Integer c : edgesList.get(v)) {
            
            // cehck to see if it has been visited already
            // and throw error is it has
            if (graphNeighbors.contains(c)) {
                throw new CatchErrors("Vertex visited already.");
            }
            // add int to graphNeighbors
            graphNeighbors.add(c); 
            
            // recursion in dfs
            depthFirstSearch(c);
        }
    }
    
    public List<String[]> fileIntoTokens(String file) throws FileNotFoundException, IOException {
        // relative file path
        String filePathString = String.format("graph_files/%s", file);
        String filePath = new File(filePathString).getAbsolutePath();

        // create new BufferedReader object
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        
        // declare variables
        String line;
        List<String[]> data = new ArrayList<>();
        int i = 0;
        
        // while there are lines to read, do the following
        while ((line = br.readLine()) != null) {
            // tokenize based on spaces
            String[] lineArray = line.split("\\s");
            
            // add tokens to List
            data.add(i, lineArray);
            i++;
        }
        
        // return tokenized fole contents
        return data;
    }
    
    // method createDirectedGraphFromFile creates vertices and edges
    public void createDirectedGraphFromFile(List<T[]> fileOutput) throws IOException, FileNotFoundException {
        // iterate over each line in the file
        for (T[] token : fileOutput) {
            
            // iterate over each token in each file line
            for (int i = 0; i < token.length; i++) {
                
                // add vertices for each line token
                addVertices(token[i]);
                
                // add edges when it's not the first token
                if (i != 0) {
                    addEdges(token[0], token[i]);
                }
            }
        }
    }
    
    // method addEdges adds edges to connect vertices
    private void addEdges (T from, T to) {
        int mapFrom = mapInt.get(from);
        int mapTo = mapInt.get(to);
        
        // inserts edge between vertices
        edgesList.get(mapFrom).add(mapTo);
    }
    
    // method addVertices adds vertex to map
    private void addVertices(T className) {
        
        // make sure each className is mapped just once
        if (!mapInt.containsKey(className)) {
            
            // map className to numVertices
            mapInt.put(className, numVertices);
            LinkedList<Integer> list = new LinkedList<>();
            edgesList.add(numVertices, list);
            
            // add 1 for next vertex
            numVertices++;
        }
    }
    
    // method indexToName get className associated with index
    private String indexToName (int vertex) {
        // iterate over keys in mapInt
        for (T i : mapInt.keySet()) {
            
            // grabe vertex value and return string
            if (mapInt.get(i).equals(vertex)) {
                return i.toString();
            }
        }
        
        // return null if no keys match
        return null;
    }
    
    public String getTopologicalOrder(T beginningVertex) throws CatchErrors {
        // throw error if class doesn't exist
        if (mapInt.get(beginningVertex) == null) {
            throw new CatchErrors("Class doesn't exist.");
        }
        
        // create new string builder, and graphNeighbors
        outputText = new StringBuilder();
        graphNeighbors = new ArrayList<>();
        
        // perform dfs
        depthFirstSearch(mapInt.get(beginningVertex));
        
        // return output
        return outputText.toString();
    }
} // end DirectedGraph