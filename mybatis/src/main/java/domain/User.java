package domain;

import annotation.DbField;
import annotation.DbTable;

/**
 * @author yxl15
 * @date 2021/3/21 15:29
 * @description
 *
 *      id 和 age 的默认值都为 null（Integer）
 */

@DbTable(tableName = "all_user")
public class User {

    @DbField("user_id")
    private Integer id;
    @DbField("user_name")
    private String username;
    @DbField("user_age")
    private Integer age;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public User(Integer id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
