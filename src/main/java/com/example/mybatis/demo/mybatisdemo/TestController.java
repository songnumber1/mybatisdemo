package com.example.mybatis.demo.mybatisdemo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.demo.mybatisdemo.Management.Factory.TestFactory;
import com.example.mybatis.demo.mybatisdemo.Management.Manager.TestManager;
import com.example.mybatis.demo.mybatisdemo.XmlDynamicBean.MyCalculator;
import com.example.mybatis.demo.mybatisdemo.XmlDynamicBean.XmlDynamicConfig;
import com.example.mybatis.demo.mybatisdemo.bean.BeanManager;
import com.example.mybatis.demo.mybatisdemo.bean.DynamicBeanTypeGenericVo;
import com.example.mybatis.demo.mybatisdemo.sample.User;
import com.example.mybatis.demo.mybatisdemo.sample.UserService;

@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    BeanManager beanManager;

    @Autowired
    ConfigurableApplicationContext context;

    @Autowired
    TestFactory testFactory;

    @Autowired
    XmlDynamicConfig xmlDynamicConfig;

    @GetMapping("/dynamicXmlBeanTest/{data}")
    public String dynamicXmlBeanTest(@PathVariable String data) {
        MyCalculator mClass = (MyCalculator) xmlDynamicConfig.getBean(MyCalculator.class,
                xmlDynamicConfig.getMycalculator());
        
        int firstNum = mClass.getFirstNum();
        int secondNum = mClass.getSecondNum();

        mClass.setFirstNum(firstNum * 2);
        mClass.setSecondNum(secondNum * 2);

        mClass.plus();

        return "dynamicXmlBeanTest : data";
    }
    
    @GetMapping("/dynamicBeanFactoryTest/{data}")
    public String dynamicBeanFactoryTest(@PathVariable String data) throws BeansException, IllegalStateException, ClassNotFoundException{
        TestManager testManager = (TestManager) context.getBeanFactory().getBean(testFactory.getManagerBeanName(),
                Class.forName(testFactory.getManagerBean()));

        return testManager.CallMethod(data);
    }
    
    @GetMapping("/dynamicBeanTest/{data}")
    public String dynamicBeanTest(@PathVariable String data)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{     
        return beanManager.GetDynamicBean().CallMethod(data);
    }

    @GetMapping("/dynamicBeanTypeTest/{data}")
    public String dynamicBeanTypeTest(@PathVariable String data)
             throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{

        DynamicBeanTypeGenericVo dynamicBenTypeGenericVo = new DynamicBeanTypeGenericVo();
        dynamicBenTypeGenericVo.setData(data);

        return beanManager.GetDynamicTypeBean().CallMethod(data, dynamicBenTypeGenericVo);
    }
    
    @GetMapping("/setAnnotation/{data}")
    public void setAnnotation(@PathVariable int data) {
        System.out.println("setAnnotation Before : " + userService.GetAnnotationData());

        userService.SetAnnotationData(data);

        System.out.println("setAnnotationAfter : " + userService.GetAnnotationData());
    }

    @GetMapping("/getUsers")
    public List<HashMap<String, Object>> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUsersDao")
    public List<HashMap<String, Object>> getUsersDao() {
        return userService.getUsersWithDao();
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        System.out.println("findAll");
        return userService.findAll();
    }

    @PostMapping("/user/insert")
    public void userInsert(@RequestBody User user) {
        System.out.println(user);
    }

    @GetMapping("/forkjoinpool")
    public void ForkJoinPoolTest() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);

        List<User> users = new ArrayList<User>();

        for (int i = 0; i < 100; i++) {
            users.add(User.builder().id(i).build());
        }

        System.out.println("Start");

        ForkJoinPool forkJoinPool = new ForkJoinPool(100);

        forkJoinPool.submit(() -> {
            users.parallelStream().forEach((vo) -> {
                System.out.println(String.format("%s - %d,", Thread.currentThread().getName(), vo.getId()));
            });
        }).join();

        forkJoinPool.shutdown();

        try {
            if (!forkJoinPool.awaitTermination(1000, TimeUnit.SECONDS)) {
                System.out.println("forkJoinPool.awaitTermination error");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            
        }
        System.out.println("End");
    }
}
