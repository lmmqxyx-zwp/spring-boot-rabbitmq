package top.by.xiceos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import top.by.xiceos.entity.User;

import java.util.List;

/**
 * <p>Title: UserDao</p>
 * <p>Description:
 * 使用JPA
 *      使用扩展方法
 *      自定义查询
 * </p>
 *
 * @author zwp
 * @date 2019/1/4 11:45
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 扩展查询
     *
     * @param name
     * @return
     */
    User findByName(String name);

    @Query("select u from User u where u.name = :name1 or u.name = :name2")
    List<User> findTwoName(@Param("name1") String name1, @Param("name2") String name2);

}
