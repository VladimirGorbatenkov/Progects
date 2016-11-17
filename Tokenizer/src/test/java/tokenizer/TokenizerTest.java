package tokenizer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class TokenizerTest {
    private Tokenizer T;

    @org.junit.Test
    public void tokenize() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        T = new Tokenizer();
    }

    @Test
    public void testTokenize() throws Exception {
        Token[] expected = new Token[8];
        expected[0] =  new WordToken(0, 3, "dfsd");
        expected[1] =  new SeparatorToken(4, 4, " ");
        expected[2] =  new WordToken(5, 9, "Dggsd");
        expected[3] =  new DigitToken(10, 13, "1212", 1212);
        expected[4] =  new SeparatorToken(14, 14, ";");
        expected[5] =  new WordToken(15, 17, "gsg");
        expected[6] =  new SeparatorToken(18, 18, ".");
        expected[7] =  new DigitToken(19, 24, "124124", 124124);
        T.tokenize("dfsd Dggsd1212;gsg.124124");
        Token[] actual = T.getTokens();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void notifyHandlers() throws Exception {

    }

}