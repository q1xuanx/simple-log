package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.ofHours(7));
        String[] times = now.toString().split("T");
        System.out.println("Input file path: ");
        String filePath = sc.nextLine();
        writeToFile("Hoàng Nhân đã tiến hành đếm file tại địa chỉ: " + filePath + " vào thời gian: " + times[0] + " times " + times[1].split("\\.")[0]);
        countNumberOfFile(filePath);
    }
    //C:\Users\ADMIN\Documents\Visual Studio 2017
    public static void writeToFile(String time) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
            writer.append(time);
            writer.append("\n");
            writer.close();
            log.info("Write success");
        } catch (IOException e) {
            log.info("Write failed " + e.getMessage());
        }
    }
    public static void countNumberOfFile(String filePath){
        filePath = filePath.replaceAll("\\\\", "/");
        System.out.println(filePath);
        File directory = new File(filePath);
        int fileCount = Objects.requireNonNull(directory.listFiles()).length;
        if (fileCount == 0){
            log.info("File is empty");
            return;
        }
        log.info("Number of files in directory " + directory.getAbsolutePath() + " is " + fileCount);
        File[] files = directory.listFiles();
        for (File file : Objects.requireNonNull(files)) {
            System.out.println("File name: " + file.getName());
        }
    }
}