package com.maksym.service.impl;

import com.maksym.service.api.FolderNameExtractor;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public class ExtensionFolderNameExtractor implements FolderNameExtractor {
    @Override
    public Set<String> extractNamesFromFiles(List<File> files) {
        return files.stream().map(file -> FilenameUtils.getExtension(file.getName())).collect(Collectors.toSet());
    }
}
