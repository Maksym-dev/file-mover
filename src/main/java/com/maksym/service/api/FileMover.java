package com.maksym.service.api;

import com.maksym.model.FolderAndFiles;

import java.io.IOException;
import java.util.List;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public interface FileMover {

    /**
     * Move files.
     *
     * @param folderAndFiles the folder and files
     * @throws IOException the io exception
     */
    void moveFilesToFolder(List<FolderAndFiles> folderAndFiles) throws IOException;
}
