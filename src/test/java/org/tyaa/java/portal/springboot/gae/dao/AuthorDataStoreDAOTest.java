/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.tyaa.java.portal.datastore.model.Author;

/**
 *
 * @author yurii
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorDataStoreDAOTest {
    
    public AuthorDataStoreDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class AuthorDataStoreDAO.
     */
    /*@Test
    public void testRead() {
        System.out.println("read");
        String _name = "";
        AuthorDataStoreDAO instance = new AuthorDataStoreDAO();
        Author expResult = null;
        Author result = instance.read(_name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
    @Test(expected = NullPointerException.class)
    public void whenConfigNonVoidRetunMethodToThrowEx_thenExIsThrown() throws Exception {
        AuthorDataStoreDAO authorDataStoreDAO = mock(AuthorDataStoreDAO.class);
        when(authorDataStoreDAO.read(""))
          .thenThrow(NullPointerException.class);

        authorDataStoreDAO.read("");
    }
}
