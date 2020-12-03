package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void payment(String name, int money) {
        String sql = "UPDATE account SET money=money+? WHERE username=?";
        jdbcTemplate.update(sql, money, name);
    }
}
