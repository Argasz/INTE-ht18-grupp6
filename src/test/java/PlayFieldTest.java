import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayFieldTest {
    private PlayField pf;


    @Test
    public void testNewFieldValid(){
        pf = new PlayField(5, 5);
    }

    @Test
    public void testNewFieldNegativeHeight(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(-1, 5);
        });

        assertEquals("Height must be greater than 0.", e.getMessage());
    }

    @Test
    public void testNewFieldNegativeWidth(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(5, -1);
        });

        assertEquals("Width must be greater than 0.", e.getMessage());
    }

    @Test
    public void testNewFieldHeightOverMax(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(PlayField.MAX_HEIGHT + 1, 2);
        });

        assertEquals("Height must be less than or equal to 200.", e.getMessage());
    }

    @Test
    public void testNewFieldWidthOverMax(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(2, PlayField.MAX_WIDTH + 1);
        });

        assertEquals( "Width must be less than or equal to 200.", e.getMessage());
    }

    @Test
    public void testNewValidFieldArraySize(){
        int length = 10;
        int width = 10;
        pf = new PlayField(length, width);
        Character[][] field = pf.getFieldArray();
        assertEquals(length, field.length);
        assertEquals(width, field[1].length);
    }

    @Test
    public void testGenerateFieldNotNullChar(){
        pf = new PlayField(10, 10);
        pf.generateField();
        Character[][] field = pf.getFieldArray();
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < pf.height; j++){
                assertNotEquals(field[i][j], ('\u0000'));
            }
        }
    }

    @Test
    public void testValidGetCharAt(){
        pf = new PlayField(10, 10);
        pf.generateField();
        Character c = 'a';
        assertEquals(c, pf.getCharAt(9, 9));
    }

    @Test
    public void testNegativeXGetCharAt(){
        pf = new PlayField(10, 10);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf.getCharAt(-1, 3);
        });
        assertEquals("Index out of bounds for argument x.", e.getMessage());
    }

    @Test
    public void testNegativeYGetCharAt(){
        pf = new PlayField(10, 10);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf.getCharAt(3, -1);
        });
        assertEquals("Index out of bounds for argument y.", e.getMessage());
    }

    @Test
    public void testTooLargeXGetCharAt(){
        pf = new PlayField(10, 10);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf.getCharAt(10, 3);
        });
        assertEquals("Index out of bounds for argument x.", e.getMessage());
    }

    @Test
    public void testTooLargeYGetCharAt(){
        pf = new PlayField(10, 10);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf.getCharAt(5, 10);
        });
        assertEquals("Index out of bounds for argument y.", e.getMessage());
    }

}