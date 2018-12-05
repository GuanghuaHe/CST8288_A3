/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import dto.Student;
import java.util.List;
import logic.StudentLogic;

/**
 * @author  Joey Yin
 * @date    Dec 1, 2018 12:35:33 PM
 * @version V1.0
 * @desc    
 */
public class Test {
    private static List<Student> students;
    private static StudentLogic studentLogic = new StudentLogic();
public static void main(String asdasd[]){
    
    
    students = studentLogic.getAllStudentByGroupId(Integer.parseInt("201"));
    
}
}
