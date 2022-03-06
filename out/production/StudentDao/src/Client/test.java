package Client;

import bean.Student;
import daoIMP.StudentDAOIMP;
import java.util.List;

public class test {
    public static void main(String[] args) {

        StudentDAOIMP impl = new StudentDAOIMP();

        // 调用 insert() 方法，向数据库中插入一条学生信息
        System.out.println("\n> 插入学号为 201902029，姓名为 “小明” 的学生：");
        Student s1 = new Student();
        s1.setID(201902029);
        s1.setName("小明");
        impl.insert(s1);
        System.out.println("> 成功增加该学生信息！");

        // 调用 update() 方法，更新他的名字
        System.out.println("\n> 更新学号为 201902029 的名字为 “小红”");
        s1.setName("小红");
        impl.update(s1);
        System.out.println("> 更新完成！\n" + "学号：" + s1.getID() + "，姓名：" + s1.getName());

        // 调用 delete() 方法，删除该学生信息
        System.out.println("\n> 删除学生 201902029 的信息：<");
        impl.delete(201902029);
        System.out.println("> 删除成功！");

        // 调用 FindAll() 方法，浏览数据库全部学生信息
        System.out.println("\n> 所有学生信息如下：");
        List<Student> students = impl.findAll();
        students.forEach(s -> System.out.println("学号：" + s.getID() + "，姓名：" + s.getName()));

        // 调用 findById() 方法，查询学号为 201901001 的学生信息
        System.out.println("\n> 查询学号为 201901001 的学生信息：");
        s1 = impl.findByID(201901001);
        System.out.println("学号：" + s1.getID() + "，姓名：" + s1.getName());

    }

}
