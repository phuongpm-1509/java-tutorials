
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

class Student {
    public String name;
    public double point;

    Student(String name, double point) {
        this.name = name;
        this.point = point;
    }
}

public class Main {
    public static <T extends Number> T getValidInput(Scanner sc, String prompt, Class<T> type) {
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                if (type == Integer.class) {
                    return type.cast(Integer.parseInt(input));
                } else if (type == Double.class) {
                    return type.cast(Double.parseDouble(input));
                } else if (type == Float.class) {
                    return type.cast(Float.parseFloat(input));
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách");
            System.out.println("3. Tính điểm trung bình");
            System.out.println("4. Tính điểm cao nhất");
            System.out.println("5. Tính điểm thấp nhất");
            System.out.println("0. Thoát");

            int choose = getValidInput(sc, "Chọn: ", Integer.class);

            switch (choose) {
                case 1:
                    students.clear();
                    int n = getValidInput(sc, "Nhập số sinh viên = ", Integer.class).intValue();

                    for (int i = 0; i < n; i++) {
                        System.out.print("SV " + (i + 1) + ": " + "Tên = ");
                        String name = sc.nextLine();

                        double point = getValidInput(sc, "SV " + (i + 1) + ": " + "Điểm = ", Double.class)
                                .doubleValue();

                        students.add(new Student(name, point));
                        System.out.println("----------");
                    }
                    break;

                case 2:
                    System.out.println("Danh sách sinh viên:");
                    int idx = 0;
                    for (Student student : students) {
                        System.out.println(
                                "SV " + (idx + 1) + ": " + "Tên: " + student.name + ", Điểm: " + student.point);
                        idx++;
                    }
                    break;

                case 3:
                    System.out.print("Điểm trung bình của các sinh viên: ");
                    double sum = 0;
                    for (Student student : students) {
                        sum += student.point;
                    }
                    double avg = sum / students.size();
                    System.out.println(String.format("%.2f", avg));
                    break;

                case 4:
                    System.out.println("Sinh viên có điểm cao nhất :");
                    Student maxStudent = Collections.max(students, Comparator.comparingDouble(s -> s.point));
                    System.out.println("SV : " + "Tên: " + maxStudent.name + ", Điểm: " + maxStudent.point);
                    break;

                case 5:
                    System.out.println("Sinh viên có điểm thấp nhất: ");
                    Student minStudent = Collections.min(students, Comparator.comparingDouble(s -> s.point));
                    System.out.println("SV : " + "Tên: " + minStudent.name + ", Điểm: " + minStudent.point);
                    break;

                case 0:
                    System.out.println("Thoát chương trình");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
    }
}
