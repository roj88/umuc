package statebirdandflower;

/**
 * filename: StateBirdAndFlower.java
 * author: roland carter
 * date: 2018-08-03
 * purpose: cmis 141 hw 4. this class takes a hashmap and finds
 *          the key within that map and returns value
 */


import java.util.HashMap;

/**
 *
 * @author rolandcarter
 */
public class StateBirdAndFlower {
    private String state;
    
    public StateBirdAndFlower(String state) {
        this.state = state;
    }
    
    public StateBirdAndFlower() {
        this.state = null;
    }
    
    // setter methods
    public void setState(String state){
        this.state = state;
    }
    
    // getter methods
    public String getState(){
        return state;
    }
    
    public String findItemInMap(HashMap<String,String> map){
        return map.get(this.state);
    }
    
}
