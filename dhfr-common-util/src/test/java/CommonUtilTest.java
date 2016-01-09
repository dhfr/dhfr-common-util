/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;
;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author denifahri
 */


public class CommonUtilTest {
    
    protected static Logger log = Logger.getLogger(CommonUtilTest.class);
    private Collection collection;
    
    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code   
        log.info("@BeforeClass - oneTimeSetUp");
    }
    
    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
        log.info("@AfterClass - oneTimeTearDown");
    }
    
    @Before
    public void setUp() {
        collection = new ArrayList();
        log.info("@Before - setUp");
    }
    
    @After
    public void tearDown() {
        collection.clear();
        log.info("@After - tearDown");
    }
    
    @Test
    public void testEmptyCollection() {
        assertTrue(collection.isEmpty());
        log.info("@Test - testEmptyCollection");
    }
    
    @Test
    public void testOneItemCollection() {
        collection.add("itemA");
        assertEquals(1, collection.size());
        log.info("@Test - testOneItemCollection");
    }
    
    @Test()
    public void divisionWithException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error(e, e);
        }
    }
}
