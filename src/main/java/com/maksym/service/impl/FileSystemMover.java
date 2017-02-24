package com.maksym.service.impl;

import com.maksym.model.FolderAndFiles;
import com.maksym.service.api.FileMover;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public class FileSystemMover implements FileMover {

    @Override
    public void moveFilesToFolder(List<FolderAndFiles> folderAndFiles) throws IOException {
        for (FolderAndFiles folderAndFilesObj : folderAndFiles) {
            moveFiles(folderAndFilesObj.getFolder(), folderAndFilesObj.getFiles());
        }
    }

    private void moveFiles(File folder, List<File> files) throws IOException {
        for (File file : files) {
            FileUtils.moveFileToDirectory(file, folder, false);
        }
    }
}
