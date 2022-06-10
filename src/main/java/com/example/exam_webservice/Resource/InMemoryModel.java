package com.example.exam_webservice.Resource;

import com.example.exam_webservice.Entity.Employee;
import com.example.exam_webservice.until.ConnectionHelper;
import com.example.exam_webservice.until.SqlConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InMemoryModel implements EmployeeModel{

    @Override
    public Employee save(Employee employee) {
        try
        {
            System.out.println("Add");
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConfig.INSERT_PRODUCT);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getSalary());
            preparedStatement.execute();
            return employee;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee update(Employee employee, int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlConfig.UPDATE_PRODUCT);
            statement.setInt(1,id);
            statement.setString(2, employee.getName());
            statement.setInt(3, employee.getSalary());
            statement.setInt(4, id);
            statement.execute();
            return employee;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findall() {
        List<Employee> list = new ArrayList<>();
        try {

            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SqlConfig.LIST_PRODUCT;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int Id = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                Employee pro = new Employee(Id,Name,salary);
                list.add(pro);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Employee findbyid(int id) {
        Employee obj = null;
        Connection connection = null;
        try {
            connection = ConnectionHelper.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SqlConfig.DETAIL_PRODUCT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet.next()) {
                int Id = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                obj = new Employee(Id,Name,salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  obj;
    }
}
