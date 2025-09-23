package com.ElevateLabs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
class Student{
   private int id;
   private String name;
   private float marks;

   public Student(int id,String name, float marks) {
      this.id=id; this.name=name; this.marks=marks;
   }

   public int getId() {return id;}
   public String getName() {return name;}
   public void setName(String name) {this.name = name;}
   public float getMarks() {return marks;}
   public void setMarks(float marks) {this.marks = marks;}

   @Override
   public String toString() {
      return "Id = " + id + ", Name = " + name + '\'' + ", Marks = " + marks;
   }
}
public class StudentManager {
   private static ArrayList<Student> students = new ArrayList<>();
   private static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
      while (true) {
         System.out.println("\nStudent Record Management");
         System.out.println("1. Add Student");
         System.out.println("2. View All Students");
         System.out.println("3. Update Student");
         System.out.println("4. Delete Student");
         System.out.println("5. Exit");
         System.out.print("Choose an option: ");

         int choice = sc.nextInt();
         switch (choice) {
            case 1: addStudent(); break;
            case 2: viewStudents(); break;
            case 3: updateStudent(); break;
            case 4: deleteStudent(); break;
            case 5: System.exit(0);
            default: System.out.println("Invalid option.");
         }
      }
   }
   private static void addStudent() {
      System.out.print("Enter id: ");
      int id = sc.nextInt();
      boolean exists = false;
      for (Student s : students)
         if (s.getId() == id) {
            exists = true;
            break;
         }
      if (exists) {
         System.out.println("⚠️ This id number is already exist! Student not added.");
         return;
      }
      sc.nextLine();
      System.out.print("Enter name: ");
      String name = sc.nextLine();
      System.out.print("Enter marks: ");
      double marks = sc.nextDouble();
      students.add(new Student(id, name, (float) marks));
      System.out.println("Student added.");
   }
   private static void viewStudents() {
      if (students.isEmpty()) {
         System.out.println("No records found.");
         return;
      }
      for (Student s : students) System.out.println(s);
   }
   private static void updateStudent() {
      System.out.print("Enter id to update: ");
      int id = sc.nextInt();
      for (Student s : students)
         if (s.getId() == id) {
            sc.nextLine();
            System.out.print("Enter new name: ");
            s.setName(sc.nextLine());
            System.out.print("Enter new marks: ");
            s.setMarks(sc.nextFloat());
            System.out.println("Record updated.");
            return;
         }
      System.out.println("Student not found.");
   }
   private static void deleteStudent() {
      System.out.print("Enter id to delete: ");
      int id = sc.nextInt();
      Iterator<Student> iterator = students.iterator();
      while (iterator.hasNext()) {
         Student s = iterator.next();
         if (s.getId() == id) {
            iterator.remove();
            System.out.println("Record deleted.");
            return;
         }
      }
      System.out.println("Student not found.");
   }
}
