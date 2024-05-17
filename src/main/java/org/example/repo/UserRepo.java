package org.example.repo;

import lombok.RequiredArgsConstructor;
import org.example.entity.MyUser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class UserRepo {
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;
    public Integer save(MyUser user){
        SimpleJdbcInsert jdbcInsert=new SimpleJdbcInsert(dataSource);
        Number number = jdbcInsert.withTableName("users")
                .usingColumns("phone", "password","full_name")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(Map.of("phone", user.getPhone(),
                                            "password", user.getPassword(),
                                            "full_name", user.getFullName()
                ));
        return number.intValue();

    }
    public MyUser findByEmail(String phone) {
        var sql = "select * from users where phone =?";
        var mapper=BeanPropertyRowMapper.newInstance(MyUser.class);
         return jdbcTemplate.queryForObject(sql,mapper,phone);
    }

    public List<MyUser> findByAll() {
        var sql="select *from users";
        var mapper=BeanPropertyRowMapper.newInstance(MyUser.class);
        return jdbcTemplate.query(sql,mapper);
    }
}
