package com.maksym.service;

import com.maksym.service.api.FolderNameExtractor;
import com.maksym.service.impl.ExtensionFolderNameExtractor;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public class ExtensionFolderNameExtractorTest {

    private FolderNameExtractor folderNameExtractor = new ExtensionFolderNameExtractor();

    @Test
    public void shouldExtractNamesFromFiles() {
        Set<String> expected = new HashSet<>();
        expected.add("txt");
        List<File> files = Arrays.asList(new File("test.txt"), new File("test2.txt"));

        Set<String> actual = folderNameExtractor.extractNamesFromFiles(files);

        assertThat(actual, equalTo(expected));
    }
}
