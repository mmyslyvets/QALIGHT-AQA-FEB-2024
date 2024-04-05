package org.collections.web.dto;

import java.sql.ResultSet;

public interface IConvertible {

    String getInsertSQL();

    Object fromResultSet(ResultSet resultSet);
}
