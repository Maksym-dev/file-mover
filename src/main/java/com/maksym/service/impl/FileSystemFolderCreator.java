package com.maksym.service.impl;

import com.maksym.service.api.FolderCreator;
import org.apache.log4j.Logger;

import java.io.File;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public class FileSystemFolderCreator implements FolderCreator {

    private static final Logger LOG = Logger.getLogger(FileSystemFolderCreator.class);

    @Override
    public File createFolder(String name, String folderPath) {
        String directoryName = folderPath + "\\" + name;
        File directory = new File(directoryName);
        if (directory.exists()) {
            LOG.info(MessageFormat.format("Folder {0} already exist.", directory.getName()));
            return directory;
        }
        if (!directory.mkdir()) {
            throw new RuntimeException("Cannot create folder.");
        }
        return directory;
    }

    @Override
    public List<File> createFolders(Set<String> names, String path) {
        return names.stream().map(name -> createFolder(name, path)).collect(Collectors.toList());
    }
}
