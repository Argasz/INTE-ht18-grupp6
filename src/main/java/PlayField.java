import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayField {

    private int height, width, size;
    private Character[][] fieldMatrix;
    private Map<Character, ArrayList<Point>> positionMap;

    static final int[] SIZES = {33, 65, 129, 257};


    public PlayField(int size){
        if(size > 4 || size < 1){
            throw new IllegalArgumentException("Size must be between 1 and 4.");
        }
        this.size = size;
        this.height = SIZES[size-1];
        this.width = SIZES[size-1];
        fieldMatrix = new Character[width][height];
        positionMap = new HashMap<>();
        generateField();
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

    public Character[][] getFieldMatrix(){
        return fieldMatrix;
    }

    public void generateField(){ // Mer komplicerad implementation senare
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if (i == 0 || j == 0 || i == fieldMatrix.length-1  || j == fieldMatrix[0].length -1 ){
                    fieldMatrix[i][j] = TILES.WALL.getSymbol();
                    putInMap(TILES.WALL.getSymbol(), new Point(i, j));
                }else{
                    fieldMatrix[i][j] = TILES.FLOOR.getSymbol();
                    putInMap(TILES.FLOOR.getSymbol(), new Point(i, j));
                }
            }
        }
    }

    public void generateBSP(){
        int numOfSplits;
        if(size == 1){
            numOfSplits = 16;
        }else{
            numOfSplits = 32;
        }

        generateWallsOnly();
        Random rand = new Random();
        Point[][]localMat = new Point[width][height];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                localMat[x][y] = new Point(x, y);
            }
        }



        Point[][][] tree = new Point[numOfSplits][][];
        tree[0] = null;
        tree[1] = localMat;
        split(tree, 2, numOfSplits);

        for(int i = tree.length-1; i > tree.length - (numOfSplits/2)-1; i--){ //Go through leaves
            buildRoom(tree[i]);
        }
        for(int i = tree.length -1; i > 2; i-=2){
            connectPartitions(tree[i], tree[i-1]);
        }

        System.out.println(this);

    }

    private void generateWallsOnly(){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(x == 0 || y == 0 || x == height-1 || y == width-1){
                    this.setCharAt(x, y, TILES.OUTERWALL.getSymbol());
                }else {
                    this.setCharAt(x, y, TILES.WALL.getSymbol());
                }
            }
        }
    }

    private void buildRoom(Point [][] partition){
        Random rand = new Random();
        int width = rand.nextInt(partition.length/2+1);
        int height = rand.nextInt(partition[0].length/2+1);
        for(int x = 1; x <= width; x++){
            for(int y = 1; y <= height; y++){
                this.setCharAt(partition[x][y].x,partition[x][y].y, TILES.FLOOR.getSymbol());
            }
        }
    }

    private void connectPartitions(Point[][] partition1, Point[][] partition2){
        Point cur = new Point();
        Point goal = new Point();
        boolean found = false;
        for(int x = 0; x < partition1.length; x++){
            for(int y = 0; y < partition1[0].length; y++){
                char c = this.getCharAt(partition1[x][y].x,partition1[x][y].y);
                char d = TILES.FLOOR.getSymbol();
                if(c == d){
                    cur = new Point(partition1[x][y].x, partition1[x][y].y);
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }

        found = false;
        for(int x = 0; x < partition2.length; x++){
            for(int y = 0; y < partition2[0].length; y++){
                char c = this.getCharAt(partition2[x][y].x, partition2[x][y].y);
                char d = TILES.FLOOR.getSymbol();
                if(c == d){
                    goal = new Point(partition2[x][y].x, partition2[x][y].y);
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }

        while(!cur.equals(goal)){
            cur = navigateAndFill(cur, goal);
        }

    }

    private Point navigateAndFill(Point cur, Point goal) {
        Point ret;
        char c = this.getCharAt(cur.x, cur.y);
        char g = TILES.WALL.getSymbol();
        if (c == g) {
            this.setCharAt(cur.x, cur.y, TILES.FLOOR.getSymbol());
        }
        if (cur.x < goal.x) {
            ret = new Point(cur.x + 1, cur.y);
            return ret;
        } else if (cur.x > goal.x) {
            ret = new Point(cur.x - 1, cur.y);
            return ret;
        } else if (cur.y < goal.y) {
            ret = new Point(cur.x, cur.y + 1);
            return ret;
        } else if (cur.y > goal.y){
            ret = new Point(cur.x, cur.y - 1);
            return ret;
        }
        ret = cur;
        return ret;
    }


    private void split (Point[][][] tree, int index, int numOfSplits){
        if(index >= numOfSplits){
            return;
        }
        Random rand = new Random();
        boolean horVer = rand.nextBoolean(); //true = horizontal, false = vertical
        int splitIndex;
        Point[][] parentMatrix = tree[index/2];

        if(horVer){
            Point[][] leftPartition;
            Point[][] rightPartition;
            splitIndex = rand.nextInt(3);
            splitIndex += parentMatrix.length/2 - 1;//Middle of array -1/0/+1
            leftPartition = new Point[splitIndex+1][parentMatrix[0].length];
            System.arraycopy(parentMatrix,0,leftPartition,0, splitIndex+1);
            rightPartition = new Point[parentMatrix.length - splitIndex-1][parentMatrix[0].length];
            System.arraycopy(parentMatrix, splitIndex, rightPartition,0, rightPartition.length);
            tree[index] = leftPartition;
            tree[index + 1] = rightPartition;
            split(tree, 2*index, numOfSplits);
            split(tree, 2*(index+1), numOfSplits);
        }else{

            splitIndex = rand.nextInt(3);
            splitIndex += parentMatrix[0].length/2 - 1;



            Point[][] topPartition;
            Point[][] bottomPartition;
            topPartition = new Point[parentMatrix.length][splitIndex];
            bottomPartition = new Point[parentMatrix.length][parentMatrix[0].length - splitIndex-1];
            for(int i = 0; i < parentMatrix.length; i++){
                System.arraycopy(parentMatrix[i], 0, topPartition[i], 0, splitIndex);
                System.arraycopy(parentMatrix[i], splitIndex, bottomPartition[i],0, bottomPartition[0].length);
            }
            tree[index] = topPartition;
            tree[index + 1] = bottomPartition;
            split(tree, 2*index, numOfSplits);
            split(tree, 2*(index+1), numOfSplits);
        }

    }


    public Character getCharAt(int x, int y){
        if(x < 0 || x >= width){
            throw new IllegalArgumentException("Index out of bounds for argument x.");
        }else if( y < 0 || y >=height){
            throw new IllegalArgumentException("Index out of bounds for argument y.");
        }
        return fieldMatrix[x][y];
    }

    public void setCharAt(int x, int y, Character c){
        if(x < 0 || x >= width){
            throw new IllegalArgumentException("Index out of bounds for argument x.");
        }else if( y < 0 || y >=height){
            throw new IllegalArgumentException("Index out of bounds for argument y.");
        }
        Point p = new Point(x, y);
        removeFromMap(fieldMatrix[x][y], p);
        fieldMatrix[x][y] = c;
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
                sb.append(fieldMatrix[x][y]);
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
