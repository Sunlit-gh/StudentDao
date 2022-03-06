package Client;

import bean.Student;
import daoIMP.StudentDAOIMP;
import java.util.List;

public class test {
    public static void main(String[] args) {

        StudentDAOIMP impl = new StudentDAOIMP();

        // ���� insert() �����������ݿ��в���һ��ѧ����Ϣ
        System.out.println("\n> ����ѧ��Ϊ 201902029������Ϊ ��С���� ��ѧ����");
        Student s1 = new Student();
        s1.setID(201902029);
        s1.setName("С��");
        impl.insert(s1);
        System.out.println("> �ɹ����Ӹ�ѧ����Ϣ��");

        // ���� update() ������������������
        System.out.println("\n> ����ѧ��Ϊ 201902029 ������Ϊ ��С�족");
        s1.setName("С��");
        impl.update(s1);
        System.out.println("> ������ɣ�\n" + "ѧ�ţ�" + s1.getID() + "��������" + s1.getName());

        // ���� delete() ������ɾ����ѧ����Ϣ
        System.out.println("\n> ɾ��ѧ�� 201902029 ����Ϣ��<");
        impl.delete(201902029);
        System.out.println("> ɾ���ɹ���");

        // ���� FindAll() ������������ݿ�ȫ��ѧ����Ϣ
        System.out.println("\n> ����ѧ����Ϣ���£�");
        List<Student> students = impl.findAll();
        students.forEach(s -> System.out.println("ѧ�ţ�" + s.getID() + "��������" + s.getName()));

        // ���� findById() ��������ѯѧ��Ϊ 201901001 ��ѧ����Ϣ
        System.out.println("\n> ��ѯѧ��Ϊ 201901001 ��ѧ����Ϣ��");
        s1 = impl.findByID(201901001);
        System.out.println("ѧ�ţ�" + s1.getID() + "��������" + s1.getName());

    }

}
