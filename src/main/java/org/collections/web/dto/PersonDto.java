package org.collections.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    //TODO: Add 'id' object to this DTO
    private String gender;
    private String nat;
    private NameDto name;
}
