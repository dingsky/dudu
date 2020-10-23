package com.dudu.dao;

import com.dudu.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Mapper
public interface StudentMapper {
    @Select("select * from tbl_student")
    @Results(value = {
            @Result(column = "studentNo", property = "studentNo", javaType = String.class),
            @Result(column = "studentName", property = "studentName", javaType = String.class)
    })
    List<Student> selectAll();

    @Insert("insert into tbl_student(studentNo, studentName) values(#{studentNo}, #{studentName})")
    int insert(Student student);

    @Select("select * from tbl_student where studentNo = #{studentNo}")
    @Results(value = {
            @Result(column = "studentNo", property = "studentNo", javaType = String.class),
            @Result(column = "studentName", property = "studentName", javaType = String.class)
    })
    Student  selectOne(@Param("studentNo") String studentNo);

    @Update("update tbl_student seta studentNo = #{studentNo},studentName = #{studentName} where studentNo = #{studentNo}")
    int updateOne(Student student);

    @Delete("delete from tbl_student where studentNo = #{studentNo}")
    int deleteOne(@Param("studentNo") String studentNo);
}
