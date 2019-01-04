package top.by.xiceos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.by.xiceos.dao.UserDao;
import top.by.xiceos.entity.User;

import java.util.List;

/**
 * <p>Title: UserController</p>
 * <p>Description: 控制器 使用JPA</p>
 *
 * @author zwp
 * @date 2019/1/3 12:02
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(@ModelAttribute User user) {
        userDao.save(user);
    }

    @ResponseBody
    @PostMapping(value = "/delete")
    public void delete(@ModelAttribute Long id) {
        User user = new User();
        user.setId(id);
        userDao.delete(user);
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public void update(@ModelAttribute User user) {
        userDao.save(user);
    }

    @ResponseBody
    @GetMapping(value = "/find/{id}")
    public User findById(@PathVariable Long id) {
        return userDao.findById(id).get();
    }

    @ResponseBody
    @GetMapping(value = "/find")
    public List<User> findAll() {
        return userDao.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/findByName")
    public User findByName(@RequestParam(value = "name") String name) {
        return userDao.findByName(name);
    }

    @ResponseBody
    @GetMapping(value = "/findTwoName")
    public List<User> findTwoName(@RequestParam(value = "name1") String name1, @RequestParam(value = "name2") String name2) {
        return userDao.findTwoName(name1, name2);
    }


}
