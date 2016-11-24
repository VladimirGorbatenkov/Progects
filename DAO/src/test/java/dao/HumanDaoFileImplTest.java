package dao;

import com.google.common.collect.Lists;
import model.Human;
import org.junit.Before;

import java.util.List;

import static org.mockito.Mockito.*;


public class HumanDaoFileImplTest {

    public final static List<Human> TEST_DATA = getTestUsers();

    private static List<Human> getTestUsers() {
        Human marsel = new Human(0, "Marsel", 22, "Kazan");
        Human nastya = new Human(0, "Nastya", 20, "Moskow");
        Human ilya = new Human(0, "Ilya", 25, "Samara");

        return Lists.newArrayList(marsel, nastya, ilya);
    }

    private HumanDaoFileImpl testingUsersDao;

    @Before
    public void setUp() throws Exception {
        HumanDaoFileImpl testingUsersDao = mock(HumanDaoFileImpl.class);
//        testingUsersDao = new HumanDaoFileImpl();
//        prepareTestData();
    }

    private void prepareTestData() {
        testingUsersDao.save(TEST_DATA.get(0));
        testingUsersDao.save(TEST_DATA.get(1));
        testingUsersDao.save(TEST_DATA.get(2));
    }

    @org.junit.Test
    public void findAll() throws Exception {
/*
        when(testingUsersDao.findAll()).thenReturn(TEST_DATA);
        List<Human> expected = TEST_DATA;
        List<Human> actual = testingUsersDao.findAll();
        assertEquals(expected, actual);
*/
    }

    @org.junit.Test
    public void find() throws Exception {

    }

    @org.junit.Test
    public void save() throws Exception {

    }

    @org.junit.Test
    public void delete() throws Exception {

    }

    @org.junit.Test
    public void update() throws Exception {

    }

}