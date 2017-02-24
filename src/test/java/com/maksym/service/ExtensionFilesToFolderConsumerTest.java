package com.maksym.service;

import com.maksym.model.FolderAndFiles;
import com.maksym.service.impl.ExtensionFilesToFolderConsumer;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public class ExtensionFilesToFolderConsumerTest {
    private ExtensionFilesToFolderConsumer consumer = new ExtensionFilesToFolderConsumer();

    @Test
    public void shouldConsumeFolderWithFilesByExtension() {
        List<File> folders = new ArrayList<>();
        List<File> files = new ArrayList<>();
        File txtFolder = new File("txt");
        folders.add(txtFolder);
        File docFolder = new File("doc");
        folders.add(docFolder);
        files.add(new File("test.txt"));
        files.add(new File("test2.txt"));
        files.add(new File("test3.txt"));
        files.add(new File("test3.doc"));

        List<FolderAndFiles> actual = consumer.consume(folders, files);
        assertThat(actual.size(), equalTo(folders.size()));
    }
}
