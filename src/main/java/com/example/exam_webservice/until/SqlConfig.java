package com.example.exam_webservice.until;

public class SqlConfig {

//  Product
    public static final String INSERT_PRODUCT = "INSERT INTO employee (name,salary) VALUES (?,?)";
    public static final String LIST_PRODUCT = "SELECT * FROM employee";
    public static final String UPDATE_PRODUCT =
            "UPDATE employee SET Id=?,name=?,salary=? WHERE Id = ?";
    public static final String DETAIL_PRODUCT = "select * from employee where Id = ?";

}
