package com.example.plugissue.user.controller.dao;

import org.aspectj.weaver.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDao {
    private NamedParameterJdbcTemplate jdbc;

    private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);

    public MemberDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    public Member getMemberByEmail(String email) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("email",email);

        return jdbc.queryForObject(MemberDaoSqls.SELECT_ALL_BY_EMAIL, map, rowMapper);
    }
}
