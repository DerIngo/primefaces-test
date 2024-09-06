package org.primefaces.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    private List<TestObject> list;

    @PostConstruct
    public void init() {
        string = "Welcome to PrimeFaces!!!";
        list = new ArrayList<>(Arrays.asList(
                new TestObject("Thriller", "Michael Jackson", 1982),
                new TestObject("Back in Black", "AC/DC", 1980),
                new TestObject("The Bodyguard", "Whitney Houston", 1992),
                new TestObject("The Dark Side of the Moon", "Pink Floyd", 1973)
        ));
    }

    public void handleFileUpload(FileUploadEvent event) throws Exception {
        UploadedFile uploadedFile = event.getFile();
        System.out.println(uploadedFile.getFileName());
        System.out.println(uploadedFile);
    }
    
}
