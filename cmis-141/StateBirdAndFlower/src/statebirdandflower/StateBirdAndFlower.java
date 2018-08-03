package statebirdandflower;

/*
 * filename: StateBirdAndFlower.java
 * author: roland carter
 * date: 2018-08-03
 * purpose: cmis 141 hw 4. this class takes a hashmap and finds
 *          the key within that map and returns value
 */

// import required packages
import java.io.IOException;
import java.util.HashMap;
import statebirdandflower.ReadData;

/**
 *
 * @author rolandcarter
 */
public class StateBirdAndFlower {
    private String state;
    private String fileDirBirds;
    private String fileDirFlowers;
    
    public StateBirdAndFlower(String state, String fileDirBirds, String fileDirFlowers) {
        this.state = state.toLowerCase();
        this.fileDirBirds = fileDirBirds;
        this.fileDirFlowers = fileDirFlowers;
    }
    
    public StateBirdAndFlower() {
        this.state = null;
        this.fileDirBirds = null;
        this.fileDirFlowers = null;
    }
    
    // setter methods
    public void setState(String state){
        this.state = state.toLowerCase();
    }
    
    public void setFileDirBirds(String fileDirBirds){
        this.fileDirBirds = fileDirBirds;
    }
    
    public void setFileDirFlowers(String fileDirFlowers){
        this.fileDirFlowers = fileDirFlowers;
    }
    
    // getter methods
    public String getState(){
        return state;
    }
    
    public String getFileDirBirds(){
        return fileDirBirds;
    }
    
    public String getFileDirFlowers(){
        return fileDirFlowers;
    }
    
    public String findItemInMap(HashMap<String,String> map){
        return map.get(this.state);
    }
    
    public String[] getBirdFlower() throws IOException{
    final String flowerFilePath =  "";
        ReadData rdFlower = new ReadData(fileDirFlowers);
        ReadData rdBird = new ReadData(fileDirBirds);
        
        String flower = findItemInMap(rdFlower.csvIntoHash());
        String bird = findItemInMap(rdBird.csvIntoHash());
        
        String [] flowerBirdArray = {flower, bird};
        
        return flowerBirdArray;
    }
    
    public String getBird() throws IOException{
        return getBirdFlower()[1];
    }
    
    public String getFlower() throws IOException{
        return getBirdFlower()[0];
    }
}
