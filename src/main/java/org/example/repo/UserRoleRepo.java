package org.example.repo;

import lombok.RequiredArgsConstructor;
import org.example.entity.Role;
import org.example.entity.UserRole;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;
@Repository
@RequiredArgsConstructor
public class UserRoleRepo {
    private final JdbcTemplate jdbcTemplate;

    public void save(Integer userId,Integer roleId){
        var sql="insert into user_role (user_id,role_id) values (?,?)";
        var mapper= BeanPropertyRowMapper.newInstance(UserRole.class);
        jdbcTemplate.update(sql,mapper,userId,roleId);
    }
}
