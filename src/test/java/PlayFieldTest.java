import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayFieldTest {
    PlayField pf;

    @BeforeEach
    void setUp() {
        pf = new PlayField( 1, 1);
    }
    @AfterEach
    void reset(){
        pf = new PlayField(1, 1);
    }

    @Test
    public void testNewFieldValid(){
        pf = new PlayField(5, 5);
    }

    @Test
    public void testNewFieldNegativeHeight(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(-1, 5);
        });

        assertEquals(e.getMessage(), "Height must be greater than 0.");
    }

    @Test
    public void testNewFieldNegativeWidth(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(5, -1);
        });

        assertEquals(e.getMessage(), "Width must be greater than 0.");
    }

    @Test
    public void testNewFieldHeightOverMax(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(201, 2);
        });

        assertEquals(e.getMessage(),"Height must be less than or equal to 200.");
    }

    @Test
    public void testNewFieldWidthOverMax(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(2, 201);
        });

        assertEquals(e.getMessage(), "Width must be less than or equal to 200.");
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

    public void testGenerateField(){
        pf.generateField();

    }

}