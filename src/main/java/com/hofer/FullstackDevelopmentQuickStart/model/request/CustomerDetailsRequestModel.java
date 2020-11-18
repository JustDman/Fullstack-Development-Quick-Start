package com.hofer.FullstackDevelopmentQuickStart.model.request;

import com.hofer.FullstackDevelopmentQuickStart.model.response.Invoice;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CustomerDetailsRequestModel {

    @NotNull(message="Nachname darf nicht NULL sein")
    private String lastName;

    @NotNull(message="Vorname darf nicht NULL sein")
    private String firstName;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
