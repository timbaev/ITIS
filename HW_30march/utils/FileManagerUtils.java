package HW_30march.utils;

import HW_30march.userInteractor.AutocompleteConsole;
import HW_30march.userInteractor.ConsoleUserPrinter;
import HW_30march.utils.exceptions.DeleteException;
import HW_30march.utils.exceptions.FileManagerException;
import HW_30march.utils.exceptions.PathNotFoundException;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Timbaev on 30.03.2017.
 *
 */
public class FileManagerUtils {

    private URI currentPath;
    private static FileManagerUtils instance;

    private FileManagerUtils() {
        currentPath = setHomeDirectory();
    }

    public static FileManagerUtils getInstance() {
        if (instance == null) {
            instance = new FileManagerUtils();
        }
        return instance;
    }

    private URI setHomeDirectory() {
        String homePath = System.getProperty("user.home");
        return Paths.get(homePath).toUri();
    }

    public void getFiles(boolean printHiddenFiles, boolean printFullInfo) throws FileManagerException {
        File files = new File(currentPath);
        if (!files.exists()) {
            throw new PathNotFoundException("Path not found!");
        }
        File[] fileLists = files.listFiles();
        if (fileLists != null) {
            for (File file : fileLists) {
                if (printHiddenFiles) {
                    if (printFullInfo) ConsoleUserPrinter.printFullInfo(file);
                    else ConsoleUserPrinter.printInfo(file.getName());
                } else {
                    if (!file.isHidden()) {
                        if (printFullInfo) ConsoleUserPrinter.printFullInfo(file);
                        else ConsoleUserPrinter.printInfo(file.getName());
                    }
                }
            }
        }
    }

    public boolean pickPath(String path) {
        File directory = null;
        if (path.contains("C:")) {
            directory = new File(Paths.get(path).toUri());
        }
        if (path.contains("..")) {
            directory = new File(currentPath);
            while (path.contains("..")) {
                directory = directory.getParentFile();
                path = path.substring(3);
            }
            if (path.length() != 0) {
                directory = new File(directory, path);
            }
        }
        if (path.equals("~")) {
            directory = new File(currentPath);
            currentPath = setHomeDirectory();
        }
        if (directory == null) {
            directory = new File(Paths.get(getCurrentPath() + "\\" + path).toUri());
        }
        if (directory.isDirectory()) {
            currentPath = directory.toURI();
            sendCompleters();
            return true;
        }
        return false;
    }

    private void sendCompleters() {
        if (AutocompleteConsole.isStarted) {
            AutocompleteConsole.getInstance().setCompleters(new File(getCurrentPath()).listFiles());
        }
    }

    public boolean remove(String file, boolean deleteDirectory, boolean deleteAnyway) throws FileManagerException {
        if (deleteDirectory) {
            File directory = new File(Paths.get(getCurrentPath() + "\\" + file).toUri());
            return removeDirectory(directory, deleteAnyway);
        }
        File deleteFile = findFileInDirectory(file);
        if (deleteFile == null) return false;
        if (deleteFile.isDirectory()) {
            File[] files = deleteFile.listFiles();
            assert files != null;
            if (files.length != 0) throw new DeleteException("Can not delete catalog, it is not empty!");
            else try {
                Files.delete(deleteFile.toPath());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //if it is not a catalog
        } else {
            if (deleteFile.canWrite()) deleteFile.delete();
            if (!deleteFile.canWrite()) {
                if (deleteAnyway) deleteFile.delete();
                else System.out.println("Permission denied for remove!");
            }
        }
        return true;
    }

    private boolean removeDirectory(File folder, boolean deleteAnyway) {
        try {
            File[] files = folder.listFiles();
            if (files == null) return false;
            for (File file : files) {
                if (file.isDirectory()) {
                    removeDirectory(file, deleteAnyway);
                } else {
                    if (!file.canWrite()) {
                        if (deleteAnyway) file.delete();
                    } else {
                        file.delete();
                    }
                }
                if (folder.listFiles().length == 0) Files.delete(folder.toPath());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean move(String file1, String file2) {
        File file = findFileInDirectory(file1);
        if (file == null) return false;
        if (file2.contains("C:")) {
            File movePathFile = new File(Paths.get(file2 + "\\" + file.getName()).toUri());
            file.renameTo(movePathFile);
            return true;
        } else {
            File moveFile = new File(Paths.get(getCurrentPath() + "\\" + file2).toUri());
            if (moveFile.isDirectory()) {
                File movePathFile = new File(Paths.get(getCurrentPath() + "\\" + file2 + "\\" + file.getName()).toUri());
                file.renameTo(movePathFile);
                return true;
            } else {
                file.renameTo(moveFile);
                return true;
            }
        }
    }

    public boolean copy(String fileName, String directory) {
        File file = findFileInDirectory(fileName);
        if (file == null) return false;
        File copyPathFile;
        String pathDistance = getCurrentPath() + "\\" + directory;
        if (directory.contains("C:")) copyPathFile = new File(Paths.get(directory).toUri());
        else copyPathFile = new File(Paths.get(pathDistance).toUri());
        if (copyPathFile.isDirectory()) {
            try {
                Files.copy(file.toPath(), new File(Paths.get(pathDistance + "\\" + file.getName()).toUri()).toPath());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private File findFileInDirectory(String fileName) {
        File currentDirectory = new File(currentPath);
        File[] files = currentDirectory.listFiles();
        if (files == null) return null;
        for (File file : files) {
            if (file.getName().equals(fileName)) return file;
        }
        return null;
    }

    public String getCurrentPath() {
        return Paths.get(currentPath).toString();
    }
}
