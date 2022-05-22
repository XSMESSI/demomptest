package com.atguigu.demomptest;

import com.atguigu.demomptest.entity.User;
import com.atguigu.demomptest.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemomptestApplicationTests {



    @Autowired
    private UserMapper userMapper;



    //mp复杂操作
    @Test
    public void testSelect(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //ge、gt、le、lt、isNull、isNotNull
//        queryWrapper.ge("age",21);
        //eq、ne
//        queryWrapper.eq("name","Tom");

        // between、notBetween
//        queryWrapper.between("age",24,28);

        //like、notLike、likeLeft、likeRight
//        queryWrapper.like("name","张");

        //orderBy、orderByDesc、orderByAsc
        queryWrapper.orderByDesc("id");
        List<User> users1 = userMapper.selectList(queryWrapper);
        System.out.println("users1 = " + users1);
    }


    //根据id删除
    @Test
    public void testDeleteId(){
        int rows = userMapper.deleteById(1528383911811481601L);
        //批量删除
//        int rowsBatch = userMapper.deleteBatchIds(Arrays.asList(1,2));
        System.out.println("rows = " + rows);
    }


    //分页查询
    @Test
    public void testSelectPage(){
        Page<User> page = new Page<>(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        //返回对象得到分页所有数据
        long pages = userPage.getPages();//总页数
        System.out.println("pages = " + pages);
        long current = userPage.getCurrent();//当前页
        System.out.println("current = " + current);
        List<User> records = userPage.getRecords();//查询数据集合
        System.out.println("records = " + records);
        long total = userPage.getTotal();//总记录数据
        System.out.println("total = " + total);
        boolean hasNext = userPage.hasNext();//下一页
        System.out.println("hasNext = " + hasNext);
        boolean hasPrevious = userPage.hasPrevious();//上一页
        System.out.println("hasPrevious = " + hasPrevious);

    }


    //简单条件查询
    @Test
    public void testSelect2(){
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("name","Jack");
        columnMap.put("age",20);
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println("users = " + users);
    }

    //多个id批量查询
    @Test
    public void testSelect1() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }


    //测试乐观锁
    @Test
    public void testOptimisticLocker(){
        //根据id进行查询
        User user = userMapper.selectById(1528373234514464769L);
        //修改
        user.setName("张三");
//        user.
        userMapper.updateById(user);
    }

    //查看表格所有数据
    @Test
    public void findAll(){
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);
    }

    //根据id进行更新
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1528321841493635073L);
        user.setName("lucyMaryleo");
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);
    }

    //添加
    @Test
    public void testAdd(){
        User user = new User();
        user.setName("王5");
        user.setAge(20);
        user.setEmail("1243@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }



}
