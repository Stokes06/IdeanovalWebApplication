package services.impl;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pojo.Client;
import pojo.User;
import services.UserService;
import tools.UserMatcher;

import static org.hamcrest.MatcherAssert.assertThat;


public class UserServiceImplTest extends TestCase {
    private UserService userService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        userService = new UserServiceImpl();
    }

    public UserServiceImplTest(String testName) {
        super(testName);
    }

    public void getUserByLogin() throws Exception {
        assertNotNull(userService.getUserByLogin("mathieu.guillaume93@gmail.com"));
    }

    public void testCreationClient(){
        userService.createClient("gui@gui.com","guigui","bar");
        System.out.println(userService.getUserByPseudo("Guigui"));
    }

    public void testGetClientById(){
        User u = userService.getUserByPseudo("Sargis");
        assertTrue(u instanceof Client);
    }
    public void testMatcherUser(){
        User u = new Client("toto", "tata","Titi");
       // userService.createClient(u.getLogin(), u.getPseudo(), u.getPassword());
        assertThat(u,new UserMatcher(userService.getUserByPseudo(u.getPseudo())));
    }

    public static Test suite(){

        TestSuite suite = new TestSuite("userServiceTest");
        suite.addTest(new UserServiceImplTest("getUserByLogin"));
        suite.addTest(new UserServiceImplTest("testCreationClient"));
        return suite;
    }
}


