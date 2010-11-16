package org.sporcic.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.sporcic.extjs.ExtDateDeserializer;
import org.sporcic.extjs.ExtDateSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

public class Contact {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonSerialize(using = ExtDateSerializer.class)
    @JsonProperty("dob")
    public Date getBirthDate() {
        return birthDate;
    }

    @JsonDeserialize(using = ExtDateDeserializer.class)
    @JsonProperty("dob")
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
