package HW_30march.userInteractor;

import HW_30march.utils.FileManagerUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Timbaev on 30.03.2017.
 */
public class ConsoleUserPrinter {

    public static void printInfo(String info) {
        System.out.println(info);
    }

    public static void printFullInfo(File file) {
        boolean read = file.canRead();
        boolean write = file.canWrite();
        boolean execute = file.canExecute();
        String permissions = getStringPermissions(read, write, execute);

        long size = file.length();
        String name = file.getName();

        String formatSize = getFormatSize(size);
        String owner = "";
        try {
            owner = Files.getOwner(file.toPath()).getName();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[] info = new String[4];
        info[0] = permissions;
        info[1] = formatSize;
        info[2] = name;
        info[3] = owner;

        System.out.format("%5s%20s%100s%35s\n", info);
    }

    private static String getFormatSize(long size) {
        String[] formats = new String[] {"byte", "KB", "MB", "GB"};
        int formatPosition = 0;
        while (size > 1024) {
            size /= 1024;
            formatPosition++;
        }
        return String.valueOf(size) + " " + formats[formatPosition];
    }

    private static String getStringPermissions(boolean read, boolean write, boolean execute) {
        StringBuilder permissions = new StringBuilder();
        if (read) permissions.append("r");
        if (write) permissions.append("w");
        if (execute) permissions.append("x");
        return permissions.toString();
    }

    public static void enterCommand() {
        String currentPath = FileManagerUtils.getInstance().getCurrentPath();
        System.out.print(currentPath + ">");
    }

    public static void printErrorCommand() {
        System.out.println("Error..command not found!");
    }
}
