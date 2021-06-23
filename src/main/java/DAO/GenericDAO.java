package DAO;

import mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object...Parameters);
    void Update(String sql,Object...parameters);
    Long insert(String sql,Object...parameters);
}
