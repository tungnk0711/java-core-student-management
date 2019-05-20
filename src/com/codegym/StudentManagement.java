package com.codegym;

public class StudentManagement {
    private Student[] students = new Student[3];
    private int count = 0;

    public int addStudent(Student student) {

        for (int i = 0; i < count; i++) {
            if (count != 0) {
                if (students[i].getName().equals(student.getName())) {
                    return -2;
                }
            }
        }

        if (count >= students.length) {
            return -1;
        }

        students[count] = student;
        count++;
        return 0;
    }

    public boolean editStudent(Student student) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == student.getId()) {
                index = i;
            }
        }

        if (index != -1) {
            students[index].setName(student.getName());
            students[index].setAge(student.getAge());
            students[index].setAddress(student.getAddress());
            students[index].setGpa(student.getGpa());
            return true;
        }

        return false;
    }

    public boolean removeStudent(int id) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                index = i;
            }
        }

        if (index != -1) {
            for (int i = index; i < students.length - 1; i++) {
                students[i] = students[i + 1];
            }
            students[students.length - 1] = null;
            count--;
            return true;
        }

        return false;
    }

    public void sortStudent() {
        Student temp = null;
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[j] != null) {
                    if (students[i].getGpa() < students[j].getGpa()) {
                        temp = students[i];
                        students[i] = students[j];
                        students[j] = temp;
                    }
                }
            }
        }
    }

    public Student[] listStudent() {
        return students;
    }
}
