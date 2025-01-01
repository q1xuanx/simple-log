package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.ofHours(7));
        String[] times = now.toString().split("T");
        writeToFile("Hoàng Nhân đã ghi log: " + times[0] + " times " + times[1].split("\\.")[0]);
    }
    public static void writeToFile(String time) {
        Logger log = Logger.getLogger(Main.class.getName());
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
}