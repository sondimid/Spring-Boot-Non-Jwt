//package com.javaweb.controllerAdvice;
//
//import java.util.ArrayList;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.javaweb.CustomException.AgeException;
//import com.javaweb.api.Errors;
//
//@ControllerAdvice
//public class ControllerAdvicor extends ResponseEntityExceptionHandler{
//	@ExceptionHandler(AgeException.class)
//	public ResponseEntity<Object> handlerAgeException(AgeException e, WebRequest request){
//		Errors error = new Errors();
//		error.setError(e.getMessage());
//		ArrayList<String> list = new ArrayList<>();
//		list.add("Doi 18 tuoi roi moi vao!");
//		error.setList(list);
//		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//}
