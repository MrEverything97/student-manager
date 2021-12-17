import IO.IOFile;
import dao.StudentDAO;
import model.Student;
import util.DateConverter;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void showMenu() {
        System.out.println("-------------------------");
        System.out.println("1.Nhập sinh viên");
        System.out.println("2.Tìm sinh viên");
        System.out.println("0.Thoát");
        System.out.println("-------------------------");
        System.out.print("Chọn chức năng (theo số ) để tiếp tục : ");

        try {
            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1 :
                    saveStudent();
                    break;
                case 2 :
                    findStudent();
                    break;
                case 0:
                    System.err.println("Tạm biệt!");
                    break;
                default:
                    System.err.println("Nhập chưa đúng, vui lòng nhập lại ");
                    showMenu();
            }
        } catch (InputMismatchException e){
            System.out.println("Nhập vào số tương ứng để tiếp tục " );
            showMenu();
        }

    }

    private static void findStudent() {
        System.out.print("Nhập vào mã sinh viên : ");
        String id = new Scanner(System.in).nextLine();
        StudentDAO.findStudentById(id);
    }

    private static void saveStudent() {

        System.out.print("Nhập vào mã sinh viên : ");
        String id = new Scanner(System.in).nextLine();
        System.out.print("Nhập vào tên sinh viên : ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Nhập vào ngày sinh : ");
        Date birthday = DateConverter.fromString(new Scanner(System.in).nextLine());
        System.out.print("Nhập vào giới tính : ");
        String sex = new Scanner(System.in).nextLine();
        System.out.print("Nhập vào quê quán : ");
        String village =  new Scanner(System.in).nextLine();
        System.out.print("Nhập vào số điện thoại : ");
        String phoneNumber = new Scanner(System.in).nextLine();

        Student student = new Student(id, name, birthday, sex, village, phoneNumber);
        IOFile.saveToFile(student);
        StudentDAO.saveStudent(student);
    }

    public static void main(String[] args) {
        while(true) {
            showMenu();
        }
    }
}
