package com.maksym.service.api;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public interface FolderCreator {
    /**
     * Create folder file if not exists.
     *
     * @param name the name
     * @param path the path
     * @return the file
     */
    File createFolder(String name, String path);

    /**
     * Create folders list.
     *
     * @param names the names
     * @param path  the path
     * @return the list
     */
    List<File> createFolders(Set<String> names, String path);
}
