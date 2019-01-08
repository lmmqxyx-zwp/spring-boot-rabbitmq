package top.by.xiceos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.by.xiceos.dao.UserDao;
import top.by.xiceos.entity.User;

import java.util.List;

/**
 * <p>Title: RestfulUserController</p>
 * <p>Description: Restful 风格</p>
 *
 * @author zwp
 * @date 2019/1/8 10:26
 */
@Controller
@RequestMapping(value = "/restfulUser")
public class RestfulUserController {

    @Autowired
    private UserDao userDao;

    @ResponseBody
    @PostMapping
    public User insert(@ModelAttribute User user) {
        return userDao.save(user);
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        userDao.delete(user);
    }

    @ResponseBody
    @PutMapping
    public void update(@ModelAttribute User user) {
        userDao.save(user);
    }

    @ResponseBody
    @GetMapping
    public User findById(@ModelAttribute User user) {
        return userDao.findById(user.getId()).get();
    }

    @ResponseBody
    @GetMapping(value = "/findAll")
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
