package com.maksym.service.impl;

import com.maksym.model.FolderAndFiles;
import com.maksym.service.api.FilesToFolderConsumer;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public class ExtensionFilesToFolderConsumer implements FilesToFolderConsumer {

    @Override
    public List<FolderAndFiles> consume(List<File> folders, List<File> files) {
        List<FolderAndFiles> folderAndFiles = new ArrayList<>(folders.size());
        for (File folder : folders) {
            List<File> filteredFiles = files.stream().filter(file -> FilenameUtils.getExtension(file.getName()).equals(folder.getName()))
                    .collect(Collectors.toList());
            folderAndFiles.add(new FolderAndFiles(folder, filteredFiles));
        }
        return folderAndFiles;
    }
}
