import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PlayFieldTest {
    private PlayField pf;

    @Test
    public void testNewFieldValid32(){
        pf = new PlayField(1);
        assertEquals(33, pf.getHeight());
        assertEquals(33, pf.getWidth());
    }

    @Test
    public void testNewFieldValid64(){
        pf = new PlayField(2);
        assertEquals(65, pf.getHeight());
        assertEquals(65, pf.getWidth());
    }

    @Test
    public void testNewFieldValid128(){
        pf = new PlayField(3);
        assertEquals(129, pf.getHeight());
        assertEquals(129, pf.getWidth());
    }

    @Test
    public void testNewFieldValid256(){
        pf = new PlayField(4);
        assertEquals(257, pf.getHeight());
        assertEquals(257, pf.getWidth());
    }

    @Test
    public void testIsTraversable64(){
        pf = new PlayField(2);
        pf.generateBSP();
        assertTrue(traverse(pf));
    }


    @Test
    public void testNewFieldNegativeSize(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(-1);
        });

        assertEquals("Size must be between 1 and 4.", e.getMessage());
    }

    @Test
    public void testNewFieldSizeOverMax(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf = new PlayField(5);
        });

        assertEquals("Size must be between 1 and 4.", e.getMessage());
    }


    @Test
    public void testNewValidFieldArraySize32(){
        int width = 33;
        int height = 33;
        pf = new PlayField(1);
        Character[][] field = pf.getFieldMatrix();
        assertEquals(height, field[0].length);
        assertEquals(width, field.length);
    }

/*    @Test
    public void testGenerateFieldNotNullChar(){
        pf = new PlayField(10, 10);
        pf.generateField();
        Character[][] field = pf.getFieldMatrix();
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < pf.getHeight(); j++){
                assertNotEquals(field[i][j], ('\u0000'));
            }
        }
    }*/

    @Test
    public void testGenerateIsTraversable(){
        pf = new PlayField (2);
        pf.generateField();
        assertTrue(traverse(pf));
    }

    private Set<Point> flood(Character[][] field, Set<Point> visited, Point pos){
        if(field[pos.x][pos.y] != TILES.FLOOR.getSymbol()){
            return visited;
        }
        field[pos.x][pos.y] = 'v';
        visited.add(pos);
        if(pos.y+1 < field[0].length){ //SOUTH
            flood(field, visited, new Point(pos.x, pos.y+1));
        }
        if(pos.x+1 < field.length){ //EAST
            flood(field, visited, new Point(pos.x+1, pos.y));
        }
        if(pos.x-1 >= 0) { //WEST
            flood(field, visited, new Point(pos.x-1, pos.y));
        }
        if(pos.y - 1 >= 0){ //NORTH
            flood(field, visited, new Point(pos.x, pos.y-1));
        }

        return visited;
    }

    private boolean traverse(PlayField field){
        Point start = field.findChars(TILES.FLOOR.getSymbol()).get(0);

        Set<Point> vis = flood(pf.getFieldMatrix(), new HashSet<Point>(), start);

        boolean found = true;
        for(Point p: field.findChars(TILES.FLOOR.getSymbol())){
            if(!vis.contains(p)){
                found = false;
            }
        }

        return found;
    }

    @Test
    public void testGenerate32(){
        pf = new PlayField(1);
        pf.generateBSP();
    }

    @Test
    public void testGenerate64(){
        pf = new PlayField(2);
        pf.generateBSP();
    }

    @Test
    public void testGenerate128(){
        pf = new PlayField(3);
        pf.generateBSP();
    }

    @Test
    public void testGenerate256(){
        pf = new PlayField(4);
        pf.generateBSP();
    }

    @Test
    public void testValidGetCharAt(){
        pf = new PlayField(1);
        pf.generateField();
        Character c = TILES.FLOOR.getSymbol();
        assertEquals(c, pf.getCharAt(9, 9)); //TODO: Skriv om?
    }

    @Test
    public void testNegativeXGetCharAt(){
        pf = new PlayField(1);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf.getCharAt(-1, 3);
        });
        assertEquals("Index out of bounds for argument x.", e.getMessage());
    }

    @Test
    public void testNegativeYGetCharAt(){
        pf = new PlayField(1);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf.getCharAt(3, -1);
        });
        assertEquals("Index out of bounds for argument y.", e.getMessage());
    }

    @Test
    public void testTooLargeXGetCharAt(){
        pf = new PlayField(1);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf.getCharAt(33, 3);
        });
        assertEquals("Index out of bounds for argument x.", e.getMessage());
    }

    @Test
    public void testTooLargeYGetCharAt(){
        pf = new PlayField(1);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            pf.getCharAt(5, 33);
        });
        assertEquals("Index out of bounds for argument y.", e.getMessage());
    }

    @Test
    public void testValidSetCharAt(){
        pf = new PlayField(2);
        pf.generateField();
        Character c = 'b';
        pf.setCharAt(8, 8, c);
        assertEquals(c, pf.getCharAt(8, 8));
    }

    @Test
    public void testSetCharAtNegativeX(){
        pf = new PlayField(1);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, ()-> {
            pf.setCharAt(-1, 2, 'b');
        });

        assertEquals(e.getMessage(), "Index out of bounds for argument x.");
    }

    @Test
    public void testSetCharAtNegativeY(){
        pf = new PlayField(1);
        pf.generateField();

        Exception e = assertThrows(IllegalArgumentException.class, ()-> {
            pf.setCharAt(2, -1, 'b');
        });

        assertEquals(e.getMessage(), "Index out of bounds for argument y.");
    }

    @Test
    public void testSetCharacterXAboveMax(){
        pf = new PlayField(1);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, ()->{
           pf.setCharAt(33, 0, 'b');
        });
        assertEquals(e.getMessage(), "Index out of bounds for argument x.");
    }

    @Test
    public void testSetCharacterYAboveMax(){
        pf = new PlayField(1);
        pf.generateField();
        Exception e = assertThrows(IllegalArgumentException.class, ()->{
            pf.setCharAt(0, 33, 'b');
        });
        assertEquals(e.getMessage(), "Index out of bounds for argument y.");
    }

    @Test
    public void testFindPos(){
        pf = new PlayField(1);
        pf.generateField();
        Character c = 'b';
        pf.setCharAt(5, 5, c);
        assertEquals(c, pf.getCharAt(5, 5));

    }

    @Test
    public void testFindValidChars(){
        pf = new PlayField(1);
        pf.generateField();
        Character c = 'b';
        pf.setCharAt(5,5, c);
        Point p1 = new Point(5, 5);
        pf.setCharAt(5,  6, c);
        Point p2 = new Point(5, 6);
        ArrayList<Point> result  = pf.findChars(c);
        assertEquals(p1, result.get(0));
        assertEquals(p2, result.get(1));

    }

}