package org.example.repo;

import lombok.RequiredArgsConstructor;
import org.example.entity.MyUser;
import org.example.entity.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RoleRepo {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    public Integer save(Role role){

        SimpleJdbcInsert simpleJdbcInsert=new SimpleJdbcInsert(dataSource);
        Number number = simpleJdbcInsert.withTableName("roles")
                .usingColumns("name")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(Map.of("name", role.getName()));
        return number.intValue();
    }

    public List<Role> findAllRoles(MyUser user) {
        var sql ="select r.* from roles r join public.user_role ur on r.id = ur.role_id where user_id=?";
        var mapper=BeanPropertyRowMapper.newInstance(Role.class);
        return jdbcTemplate.query(sql,mapper,user.getId());
    }
}
