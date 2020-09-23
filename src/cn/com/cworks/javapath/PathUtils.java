package cn.com.cworks.javapath;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

/**
 * @Description
 * @Author LuChao
 * @Date 2020/9/9
 * @Version 1.0
 */
public class PathUtils {

    /**
     * @param path 要创建的文件的路径
     * @return 空
     * @author LuChao
     * @describe 创建文件，包含路径存在的情况
     * @date 2020/9/9
     */
    public static void makeFile(Path path) throws IOException {
        if (!Files.exists(path)) {
            int pathNameCount = path.getNameCount();
            Path dir = path.subpath(0, pathNameCount - 1);
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }
            Files.createFile(path);
        }
    }

    public static void main(String[] args) throws IOException {

    }

    @Test
    public void test1() {
        Path path = Paths.get("path/test.txt");

        // 获取文件名称
        System.out.println(path.getFileName()); //test.txt
        // 获取父路径
        System.out.println(path.getParent());//path
        // 获取path中有几个节点
        System.out.println(path.getNameCount());//2
        // 获取某个节点的Path
        System.out.println(path.getName(0));
        // 判断是否绝对路径
        System.out.println(path.isAbsolute());//false
        // 获取绝对路径的Path
        System.out.println(path.toAbsolutePath());
        // 截取节点
        System.out.println(path.subpath(0, 1));//path
        // 转换为Uri
        System.out.println(path.toUri());

    }

    @Test
    public void test2() throws IOException {
        Path path = Paths.get("path/test.txt");
        // 查询文件是否存在
        System.out.println(Files.exists(path));
        // 查询是否有读写执行的权限
        System.out.println(Files.isRegularFile(path) && Files.isReadable(path) && Files.isExecutable(path));
        // 删除文件
//        Files.delete(path);
//        Files.deleteIfExists(path);
        //文件复制 CopyOption
//        Files.copy(path,Paths.get("path/test.txt"), StandardCopyOption.REPLACE_EXISTING);
        // 文件移动
//        Files.move(path,Paths.get("path/test.txt"),StandardCopyOption.REPLACE_EXISTING);
        //读取文件
        Files.readAllBytes(path);
        List<String> strings = Files.readAllLines(path, StandardCharsets.UTF_8);
        // 写文件
        Files.write(path, strings, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

    }

    @Test
    public void test3() throws IOException {
        // 目录操作
        Path path = Paths.get("path");
//        DirectoryStream<Path> paths = Files.newDirectoryStream(path);
//        paths.forEach(System.out::println);
//        paths.close();
        // 加过滤条件
//        DirectoryStream<Path> paths = Files.newDirectoryStream(path, Files::isExecutable);
//        paths.forEach(System.out::println);
        DirectoryStream<Path> paths = Files.newDirectoryStream(path, "*.txt");
        paths.forEach(System.out::println);

    }
}
