package io.sunnybeta.calc.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;

public class ResponseHandler {
	public static ResponseEntity<Object> handle(Object data, HttpStatus status) {
		HashMap<String,Object> res = new HashMap<>();
		res.put("data", data);
		res.put("status", status);
		return new ResponseEntity<>(res, status);
	}
}
