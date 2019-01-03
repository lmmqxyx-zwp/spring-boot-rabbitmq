package top.by.xiceos.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>Title: User</p>
 * <p>Description: 用户表</p>
 *
 * @author zwp
 * @date 2019/1/3 11:41
 */
@Entity
@Table(name = "auth_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UserSequence")
    //@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "UserSequence", sequenceName = "User_Sequence", allocationSize = 1)
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String account;
    @Column(length = 64)
    private String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "\n[ =======\n" +"id: " + this.id + ", \n" + "name: " + this.name + ", \n" + "account: " + this.account +
                ", \n" + "pwd: " + this.pwd+ "\n======= ]";
    }
}

// UUID 作为主键
// @Id
// @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
// @GeneratedValue(generator="idGenerator")
