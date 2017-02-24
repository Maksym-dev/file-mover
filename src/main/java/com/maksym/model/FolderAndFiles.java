package com.maksym.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.File;
import java.util.List;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public class FolderAndFiles {

    private File folder;

    private List<File> files;

    public FolderAndFiles() {
    }

    public FolderAndFiles(File folder, List<File> files) {
        this.folder = folder;
        this.files = files;
    }

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof FolderAndFiles)) {
            return false;
        }

        FolderAndFiles that = (FolderAndFiles) o;

        return new EqualsBuilder()
                .append(folder, that.folder)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(folder)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("folder", folder)
                .append("files", files)
                .toString();
    }
}
