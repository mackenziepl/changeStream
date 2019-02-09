package com.demo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class File {

    public List<Path> search(List<String> params) throws IOException {
        return Files.walk(Paths.get(params.get(0)))
                .filter(path -> path.toFile().isFile())
                .filter(t -> t.toFile().getPath().endsWith("." + params.get(1)))
                .collect(Collectors.toList());
    }

    public void change(List<Path> pathFile, List<String> params) throws IOException {
        for (Path file : pathFile) {
            String fileName = file.toString();
            BufferedReader brFile  = new BufferedReader(new FileReader(fileName));

            StringBuilder sb = new StringBuilder();

            int content;
            while ((content = brFile.read()) != -1) {
                sb.append((char) content);
            }

            List<String> temp = Collections.singletonList(sb.toString().replace(params.get(2), params.get(3)));

            BufferedWriter bwFileOut = new BufferedWriter(new FileWriter(fileName));

            for(String s : temp) {
                bwFileOut.write(s);
            }
            bwFileOut.close();
            brFile.close();
        }
    }
}
