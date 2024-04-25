package org.primefaces.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
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
                new TestObject("The Dark Side of the Moon", "Pink Floyd", 1973),
                new TestObject(null, "random Artist Name", null)
        ));
    }

    public String action() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean validationFailed = false;
        
        // Check if any inputText in the dataTable has invalid value
        for (TestObject testObject : list) {
            if (testObject.getName() == null || testObject.getName().isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error FROM ACTION METHOD", "Name is required."));
                validationFailed = true;
            } 
        }
        
        // If validation failed, return null to stay on the same page
        if (validationFailed) {
            return null;
        }        
        
        System.out.println("list:");
        list.forEach(System.out::println);
        return null;
    }
    
}
