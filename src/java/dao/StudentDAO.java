package dao;

import dto.Student;
import java.util.List;

public interface StudentDAO extends BaseDAO<Student>{
    public List<Student> getAllStudentByGroupId(int id);
}
