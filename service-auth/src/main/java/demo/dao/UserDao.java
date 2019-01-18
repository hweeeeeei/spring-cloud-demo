package demo.dao;

import demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserDao 继承了JpaRepository
 */
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

}