package com.maksym.facade.api;

import java.io.IOException;

/**
 * Created by Maksym on 24.02.2017.
 */
public interface FileMoverFacade {
    /**
     * Move files in folder.
     *
     * @param folder the folder
     * @return the result of moving files in folder
     * @throws IOException the io exception
     */
    boolean moveFilesInFolder(String folder) throws IOException;
}
