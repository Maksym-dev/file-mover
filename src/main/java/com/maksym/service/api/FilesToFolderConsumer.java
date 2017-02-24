package com.maksym.service.api;

import com.maksym.model.FolderAndFiles;

import java.io.File;
import java.util.List;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public interface FilesToFolderConsumer {
    /**
     * Consume list.
     *
     * @param folders the folders
     * @param files   the files
     * @return the list
     */
    List<FolderAndFiles> consume(List<File> folders, List<File> files);
}
