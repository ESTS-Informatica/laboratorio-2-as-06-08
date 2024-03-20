import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {
    Property property1;
    @Test
    @BeforeEach
    public void PropertyTest() {
        property1 = new Property("T3 Monte Belo", 150000.0);
        assertEquals("T3 Monte Belo",property1.getDescription());
        assertEquals(150000.0, property1.getPrice());
    }
    @Test
    public void toStringTest(){
        //property1 = new Property("T3 Monte Belo", 150000.0);
        StringBuilder sb = new StringBuilder();
        sb.append("Descrição   :").append("T3 Monte Belo").append("\n").append("Preco   :").append(150000.0);
        assertEquals(sb.toString(),property1.toString());
    }

}



