package com.project.splitwise.dtos;


import lombok.Data;
import lombok.Setter;


@Data
public class Response {

    private String message;

    private ResponseType type;


    public static Response getSuccessResponse(){
        Response response=new Response();
        response.setType(ResponseType.SUCCESS);

         return response;
    }


    public static Response getFailureResponse(String message) {
        Response response = new Response();
        response.setType(ResponseType.FAILURE);
        response.setMessage(message);
        return response;
    }
}
