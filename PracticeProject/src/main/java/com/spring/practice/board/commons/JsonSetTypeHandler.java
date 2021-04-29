package com.spring.practice.board.commons;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSetTypeHandler extends BaseTypeHandler<Set<?>> {
  private static final ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

  private final JavaType javaType;

  public JsonSetTypeHandler(Class<?> clazz) {
    if (clazz == null)
      throw new IllegalArgumentException("Type argument cannot be null");
    this.javaType = mapper.getTypeFactory().constructCollectionType(Set.class, clazz);
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps,
      int i, Set<?> parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setString(i, this.toJson(parameter));
  }

  @Override
  public Set<?> getNullableResult(ResultSet rs,
      String columnName) throws SQLException {
    return this.toSet(rs.getString(columnName));
  }

  @Override
  public Set<?> getNullableResult(ResultSet rs,
      int columnIndex) throws SQLException {
    return this.toSet(rs.getString(columnIndex));
  }

  @Override
  public Set<?> getNullableResult(CallableStatement cs,
      int columnIndex) throws SQLException {
    return this.toSet(cs.getString(columnIndex));
  }

  private String toJson(Object object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private Set<?> toSet(String content) {
    if (content != null && !content.isEmpty()) {
      try {
        return mapper.readValue(content, javaType);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    } else {
      return null;
    }
  }
  
  
}
