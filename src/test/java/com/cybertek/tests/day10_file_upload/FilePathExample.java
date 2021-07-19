package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test1() {
        // /Users/jamaldemir/IdeaProjects/fromgit/EU3TestNGSelenium/src/test/resources/textfile.txt

        // /Users/jamaldemir/IdeaProjects/fromgit/EU3TestNGSelenium src/test/resources/textfile.txt;
        //System.out.println(System.getProperty("user.dir"));
        /*
        System.out.println(System.getProperty("os.name"));
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);

        String filePath = "src/test/resources/textfile.txt";

        String fullPath = projectPath+"/"+filePath;
        System.out.println(fullPath);  */

        //C:\Users\Administrator\IdeaProjects\src\test\resources\textfile.txt
        //src/test/resources/textfile.txt

        System.out.println(System.getProperty("os.name"));
        String projectPath1 = System.getProperty("user.dir");
        System.out.println("projectPath1 = " + projectPath1);
        String filePath1 = "src/test/resources/textfile.txt";
        String fullPath1 = projectPath1 + "/" + filePath1;
        System.out.println(fullPath1);
    }
}