public class PlayField {
    int height, width;
    Character[][] fieldArray;
    public static final int MAX_WIDTH = 200;
    public static final int MAX_HEIGHT = 200;


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
    }

    public Character[][] getFieldArray(){
        return fieldArray;
    }

    public void generateField(){ // Mer komplicerad implementation senare
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                fieldArray[i][j] = 'a';
            }
        }
    }

    public Character getCharAt(int x, int y){
        if(x < 1 || x >= width){
            throw new IllegalArgumentException("Index out of bounds for argument x.");
        }else if( y < 1 || y >=height){
            throw new IllegalArgumentException("Index out of bounds for argument y.");
        }
        return fieldArray[x][y];
    }


}
