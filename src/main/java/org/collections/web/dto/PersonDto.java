package org.collections.web.dto;

import lombok.*;
import org.collections.web.util.DbUtil;

import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto implements IConvertible {

    private String gender;
    private String nat;
    private NameDto name;

    private final static String INSERT_PERSON =
            "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%s')";

    private final static String GET_RANDOM_PERSON_SQL =
            "SELECT * FROM Persons ORDER BY RAND() LIMIT 1";

    private final static String GET_ALL_PERSONS =
            "SELECT * FROM Persons";

    public String getInsertSQL() {
        return String.format(INSERT_PERSON,
                this.getName().getFirst(),
                this.getName().getLast(),
                this.getGender(),
                this.getName().getTitle(),
                this.getNat());
    }

    @SneakyThrows
    public static PersonDto getRandomPersonFromDB() {
        List<Object> resultSet =
                DbUtil.executeSelectStatement(GET_RANDOM_PERSON_SQL, new PersonDto());
        if (!resultSet.isEmpty()) {
            return (PersonDto) resultSet.get(0);
        }
        return null;
    }

    @SneakyThrows
    public static List<PersonDto> getAllUsersFromDB() {
        List<Object> resultSet =
                DbUtil.executeSelectStatement(GET_ALL_PERSONS, new PersonDto());
        if (!resultSet.isEmpty()) {
            return resultSet.stream().map(o -> (PersonDto) o).collect(Collectors.toList());
        }
        return null;
    }

    @SneakyThrows
    public Object fromResultSet(ResultSet resultSet) {
        return PersonDto.builder()
                .nat(resultSet.getString("Nat"))
                .gender(resultSet.getString("Gender"))
                .name(NameDto.builder()
                        .first(resultSet.getString("FirstName"))
                        .last(resultSet.getString("LastName"))
                        .title(resultSet.getString("Title"))
                        .build()
                ).build();
    }
}
