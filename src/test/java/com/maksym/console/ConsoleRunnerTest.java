package com.maksym.console;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public class ConsoleRunnerTest {

    @Test
    public void should() throws IOException {
        String rootFolder = "./src/test/resources/rootTest";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(rootFolder.getBytes()));
            ConsoleRunner.main(new String[] {rootFolder});
        } finally {
            System.setIn(stdin);
        }
    }
}
