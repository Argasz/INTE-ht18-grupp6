import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayField {

    private int height, width;
    private Character[][] fieldArray;
    private Map<Character, ArrayList<Point>> positionMap;

    static final int MAX_WIDTH = 200; //TODO: Lägg till min
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
                if (i == 0 || j == 0 || i == fieldArray.length-1  || j == fieldArray[0].length -1 ){
                    fieldArray[i][j] = TILES.WALL.getSymbol();
                    putInMap(TILES.WALL.getSymbol(), new Point(i, j));
                }else{
                    fieldArray[i][j] = TILES.FLOOR.getSymbol();
                    putInMap(TILES.FLOOR.getSymbol(), new Point(i, j));
                }
            }
        }
        System.out.print(this);
    }

    public void generateBSP(){
        int numSplits = 4;
        Random rand = new Random();
        Character[][]localMat = new Character[width][height];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                localMat[x][y] = TILES.WALL.getSymbol();
            }
        }



        Character[][][] tree = new Character[20][][];
        tree[0] = null;
        tree[1] = localMat;
        split(tree, 2);

        StringBuilder sb = new StringBuilder();

        //TODO: Points not chars?

        for(Character[][] c: tree){
            sb.append("[");
            for(int y = 0; y < c[0].length; y++){
                for(int x = 0; x < c.length; x++ ){
                    sb.append(c[x][y]);
                    sb.append(", ");
                }
                sb.append("\n");
            }
            sb.append("]");
            sb.append("\n");
        }
        sb.append("\n");
        System.out.print(sb.toString());
    }




    private void split (Character[][][] tree, int index){
        if(index == 16){
            return;
        }
        Random rand = new Random();
        boolean horVer = rand.nextBoolean(); //true = horizontal, false = vertical
        int splitIndex;
        System.out.println(index/2);
        Character[][] parentMatrix = tree[index/2];

        if(horVer){
            Character[][] leftPartition;
            Character[][] rightPartition;
            splitIndex = rand.nextInt(parentMatrix.length-4) + 2;
            leftPartition = new Character[splitIndex+1][parentMatrix[0].length];
            System.arraycopy(parentMatrix,0,leftPartition,0, splitIndex+1);
            rightPartition = new Character[parentMatrix.length - splitIndex-1][parentMatrix[0].length];
            System.arraycopy(parentMatrix, splitIndex+1, rightPartition,0, rightPartition.length);
            tree[index] = leftPartition;
            tree[index + 1] = rightPartition;
            split(tree, 2*index);
            split(tree, 2*index+1);
        }else{
            splitIndex = rand.nextInt(parentMatrix[0].length-4) + 2;
            Character[][] topPartition;
            Character[][] bottomPartition;
            topPartition = new Character[parentMatrix.length][splitIndex];
            bottomPartition = new Character[parentMatrix.length][parentMatrix[0].length - splitIndex - 1];
            for(int i = 0; i < parentMatrix.length; i++){
                System.arraycopy(parentMatrix[i], 0, topPartition[i], 0, splitIndex);
                System.arraycopy(parentMatrix[i], splitIndex+1, bottomPartition[i],0, bottomPartition[0].length);
            }
            tree[index] = topPartition;
            tree[index + 1] = bottomPartition;
            split(tree, 2*index);
            split(tree, 2*index+1);
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                sb.append(fieldArray[x][y]);
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
