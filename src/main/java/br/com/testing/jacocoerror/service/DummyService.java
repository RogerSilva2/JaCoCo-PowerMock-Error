package br.com.testing.jacocoerror.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class DummyService {

    public File getFile() throws IOException {
        File file = new File("test.pdf");
        if (!file.exists() || file.isDirectory()) {
            throw new IOException();
        }
        return file;
    }
}