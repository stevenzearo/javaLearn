package day09.fileInput;

import java.io.File;

public interface FileProcess {
//    递归遍历节点及子节点下的所有文件
    public void listAllFiles(File file);
//    遍历绝对路径中父节点下的的所有文件
    public void listAllParentFiles(File file);
//    遍历路径下的所有子目录
    public void listAllDirs(File file);

}
