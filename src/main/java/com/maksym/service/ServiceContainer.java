package com.maksym.service;

import com.maksym.service.api.FileMover;
import com.maksym.service.api.FilesToFolderConsumer;
import com.maksym.service.api.FolderCreator;
import com.maksym.service.api.FolderNameExtractor;
import com.maksym.service.impl.ExtensionFilesToFolderConsumer;
import com.maksym.service.impl.ExtensionFolderNameExtractor;
import com.maksym.service.impl.FileSystemFolderCreator;
import com.maksym.service.impl.FileSystemMover;

/**
 * Created by Maksym on 24.02.2017.
 */
public final class ServiceContainer {

    private static FileMover fileMover;

    private static FolderCreator folderCreator;

    private static FolderNameExtractor folderNameExtractor;

    private static FilesToFolderConsumer filesToFolderConsumer;

    private ServiceContainer() {
        throw new UnsupportedOperationException("Class is not designed for instantiation.");
    }

    /**
     * Gets file system mover.
     *
     * @return the file system mover
     */
    public static synchronized FileMover getFileSystemMover() {
        if (fileMover == null) {
            fileMover = new FileSystemMover();
        }
        return fileMover;
    }

    /**
     * Gets file system folder creator.
     *
     * @return the file system folder creator
     */
    public static synchronized FolderCreator getFileSystemFolderCreator() {
        if (folderCreator == null) {
            folderCreator = new FileSystemFolderCreator();
        }
        return folderCreator;
    }

    /**
     * Gets extension folder name extractor.
     *
     * @return the extension folder name extractor
     */
    public static synchronized FolderNameExtractor getExtensionFolderNameExtractor() {
        if (folderNameExtractor == null) {
            folderNameExtractor = new ExtensionFolderNameExtractor();
        }
        return  folderNameExtractor;
    }

    /**
     * Gets extension files to folder consumer.
     *
     * @return the extension files to folder consumer
     */
    public static synchronized FilesToFolderConsumer getExtensionFilesToFolderConsumer() {
        if (filesToFolderConsumer == null) {
            filesToFolderConsumer = new ExtensionFilesToFolderConsumer();
        }
        return  filesToFolderConsumer;
    }
}
