package com.nisaxap.springapp.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameView {

    @Value("#{target.id + ' ' + target.firstName}")
    String getFirstName();

    String getLastName();
}
