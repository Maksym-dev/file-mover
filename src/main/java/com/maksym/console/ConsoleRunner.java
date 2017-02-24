package com.maksym.console;

import com.maksym.facade.api.FileMoverFacade;
import com.maksym.facade.impl.FileMoverFacadeImpl;
import com.maksym.service.ServiceContainer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maksym_Hridin on 2/23/2017.
 */
public class ConsoleRunner {

    private FileMoverFacade fileMoverFacade;

    private static final Logger LOG = Logger.getLogger(ConsoleRunner.class);

    /**
     * Instantiates a new Console runner.
     */
    public ConsoleRunner() {
        fileMoverFacade = new FileMoverFacadeImpl(ServiceContainer.getFileSystemMover(),
                ServiceContainer.getFileSystemFolderCreator(),
                ServiceContainer.getExtensionFolderNameExtractor(), ServiceContainer.getExtensionFilesToFolderConsumer());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        ConsoleRunner runner = new ConsoleRunner();
        runner.run();
    }

    private void run() {
        System.out.println("Enter root directory.");
        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
            String rootDirectoryName = scanner.nextLine();
            if (fileMoverFacade.moveFilesInFolder(rootDirectoryName)) {
                System.out.println("Moving files successful complete.");
            } else {
                System.out.println("Moving files unsuccessful complete. See logs for more details.");
            }
        } catch (IOException e) {
            LOG.error(e);
            System.err.println("Cannot move files to folders. See logs for more details.");
        }
    }
}
