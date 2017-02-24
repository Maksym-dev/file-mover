package com.maksym.facade.impl;

import com.maksym.facade.api.FileMoverFacade;
import com.maksym.service.api.FileMover;
import com.maksym.service.api.FilesToFolderConsumer;
import com.maksym.service.api.FolderCreator;
import com.maksym.service.api.FolderNameExtractor;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maksym on 24.02.2017.
 */
public class FileMoverFacadeImpl implements FileMoverFacade {

    private static final Logger LOG = Logger.getLogger(FileMoverFacadeImpl.class);

    private FileMover fileMover;

    private FolderCreator folderCreator;

    private FolderNameExtractor folderNameExtractor;

    private FilesToFolderConsumer filesToFolderConsumer;

    public FileMoverFacadeImpl(FileMover fileMover, FolderCreator folderCreator, FolderNameExtractor folderNameExtractor,
                               FilesToFolderConsumer filesToFolderConsumer) {
        this.fileMover = fileMover;
        this.folderCreator = folderCreator;
        this.folderNameExtractor = folderNameExtractor;
        this.filesToFolderConsumer = filesToFolderConsumer;
    }

    @Override
    public boolean moveFilesInFolder(String pathToFolder) throws IOException {
        File rootDir = new File(pathToFolder);
        if (!rootDir.exists()) {
            LOG.error("Input path does not exists.");
            return false;
        }
        if (!rootDir.isDirectory()) {
            LOG.error("Input path is not directory.");
            return false;
        }
        File[] filesArray = rootDir.listFiles();
        if (filesArray != null) {
            List<File> files = Arrays.asList(filesArray);
            List<File> folders = folderCreator.createFolders(folderNameExtractor.extractNamesFromFiles(files), pathToFolder);
            fileMover.moveFilesToFolder(filesToFolderConsumer.consume(folders, files));
            LOG.info("Moving files successful complete.");
        }
        return true;
    }
}
