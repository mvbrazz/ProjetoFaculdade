package Projeto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Teste {
    
    @Test
    public void testaValoresIdeaisArgiloso(){
	assertEquals(new Nutrientes(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0),Nutrientes.ValoresIdeais("argiloso"));
    }
    
    @Test
    public void testaValoresIdeaisMedio(){
	assertEquals(new Nutrientes(12.0,0.25,3.0,1.0,6.0,0.0,0.0),Nutrientes.ValoresIdeais("medio"));
    }
    
}
