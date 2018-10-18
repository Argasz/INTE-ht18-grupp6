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


}
