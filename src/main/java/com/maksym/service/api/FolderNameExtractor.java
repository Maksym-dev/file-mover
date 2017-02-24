package com.maksym.service.api;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public interface FolderNameExtractor {
    /**
     * Extract names from files.
     *
     * @param files the files
     * @return the set of filenames
     */
    Set<String> extractNamesFromFiles(List<File> files);
}
