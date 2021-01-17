package ro.mta.se.lab.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrasTest {

    private Oras aux;

    @Before
    public void setUp() throws Exception {
        this.aux=new Oras("683506","Bucharest","26.1063", "44.4323", "RO");
    }


    @Test
    public void getNume() {
        assertEquals("Bucharest",this.aux.getNume());
    }

    @Test
    public void getTara() {
        assertEquals("RO",this.aux.getTara());
    }

    @Test
    public void getId() {
        assertEquals("683506",this.aux.getId());
    }
}