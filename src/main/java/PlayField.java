import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayField {
    private int height, width;
    private Character[][] fieldArray;
    private Map<Character, ArrayList<Point>> positionMap;

    static final int MAX_WIDTH = 200;
    static final int MAX_HEIGHT = 200;


    public PlayField(int height, int width){

        if(height < 1){
            throw new IllegalArgumentException("Height must be greater than 0.");
        }else if(width < 1){
            throw new IllegalArgumentException("Width must be greater than 0.");
        }

        if(height > 200){
            throw new IllegalArgumentException("Height must be less than or equal to 200.");
        }else if(width > 200){
            throw new IllegalArgumentException("Width must be less than or equal to 200.");
        }


        this.height = height;
        this.width = width;
        fieldArray = new Character[width][height];
        positionMap = new HashMap<>();
    }

    private void putInMap(Character c, Point p){
        if(positionMap.containsKey(c)){
            positionMap.get(c).add(p);
        }else{
            ArrayList<Point> putList = new ArrayList<>();
            putList.add(p);
            positionMap.put(c, putList);
        }
    }

    private void removeFromMap(Character c, Point p){
        positionMap.get(c).remove(p);
    }

    public Character[][] getFieldArray(){
        return fieldArray;
    }

    public void generateField(){ // Mer komplicerad implementation senare
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                fieldArray[i][j] = 'a';
                putInMap('a', new Point(i, j));

            }
        }
    }

    public Character getCharAt(int x, int y){
        if(x < 0 || x >= width){
            throw new IllegalArgumentException("Index out of bounds for argument x.");
        }else if( y < 0 || y >=height){
            throw new IllegalArgumentException("Index out of bounds for argument y.");
        }
        return fieldArray[x][y];
    }

    public void setCharAt(int x, int y, Character c){
        if(x < 0 || x >= width){
            throw new IllegalArgumentException("Index out of bounds for argument x.");
        }else if( y < 0 || y >=height){
            throw new IllegalArgumentException("Index out of bounds for argument y.");
        }
        Point p = new Point(x, y);
        removeFromMap(fieldArray[x][y], p);
        fieldArray[x][y] = c;
        putInMap(c, p);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<Point> findChars(Character c){
        return positionMap.get(c);
    }
}
