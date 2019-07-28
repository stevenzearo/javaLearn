package day09.fileInput;

import java.io.File;

public class FileProcessImpl implements FileProcess {


    @Override
    public void listAllFiles(File file) {
        File[] fileList = file.listFiles();
        if (fileList != null) {
            for (int i = 0; i < fileList.length; i++) {
                File tempFile = fileList[i];
                if (tempFile.isDirectory()){
                    listAllFiles(tempFile);
                } else if (tempFile.isFile()){
                    System.out.println(tempFile.getName());
                }
            }
        }


    }

    @Override
    public void listAllParentFiles(File file) {
        int countDirs = 0;
        int countFiles = 0;
        File absoluteFile = file.getAbsoluteFile();
        File parentAbsolute = absoluteFile.getParentFile();
        File[] files = parentAbsolute.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                System.out.println("Directory: " + files[i].getName());
                countDirs += 1 ;
            } else {
                System.out.println("File: " + files[i].getName());
                countFiles += 1;
            }

        }
        System.out.println("Directories: " + countDirs);
        System.out.println("Files: " + countFiles);
    }

    @Override
    public void listAllDirs(File file) {
        int count = 0;
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                System.out.println("Directory: " + files[i].getName());
                count += 1;
            }
        }

        System.out.println("Directories: " + count);
    }
}
