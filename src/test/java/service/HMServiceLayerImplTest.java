package service;

import dao.HMDao;
import dao.HMDaoStubImpl;
import dao.HangManPersistenceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HMServiceLayerImplTest {

    HMDao dao = new HMDaoStubImpl();
    HMServiceLayer service = new HMServiceLayerImpl(dao);

    HMServiceLayerImplTest() throws HangManPersistenceException {
    }

    @Test
    void getAllWordsFromFile() {
        assertEquals(1, service.getAllWordsFromFile().size());
    }

    @Test
    void checkUserLetter() {
        assertEquals(true,service.checkUserLetter("i"));
    }

    @Test
    void getRandomWord() {
        assertEquals("interview", service.getRandomWord());

    }

    @Test
    void countNumberOfWrongGuesses() {
        assertEquals(3,service.getNumberOfGuesses());
    }

    @Test
    void getLetterArray() {
        assertEquals("interview".length(), service.getLetterArray().length);
    }

}