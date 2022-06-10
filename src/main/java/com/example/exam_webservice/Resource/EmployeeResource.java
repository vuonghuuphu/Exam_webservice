package com.example.exam_webservice.Resource;


import com.example.exam_webservice.Entity.Employee;

import javax.ws.rs.*;
import java.util.List;

@Path("/employee")
@Produces("application/json")
@Consumes("application/json")
public class EmployeeResource {

    EmployeeModel productModel;

    public EmployeeResource(){
        productModel = new InMemoryModel();
    }

    @GET
    public List<Employee> productlist() {
        return productModel.findall();
    }

    @GET
    @Path("{id}")
    public Employee productdetail(@PathParam("id") int id) {
        return productModel.findbyid(id);
    }

    @POST
    public Employee Create (Employee employee){
        return productModel.save(employee);
    }

    @PUT
    @Path("{id}")
    public Employee update (@PathParam("id")int id,Employee product){
        return productModel.update(product,id);
    }


}