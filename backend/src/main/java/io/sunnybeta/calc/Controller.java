package io.sunnybeta.calc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.sunnybeta.calc.api.ResponseHandler;
import io.sunnybeta.calc.model.ExpressionModel;
import io.sunnybeta.calc.evaluator.Evaluator;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("")
public class Controller {

	private Evaluator evaluator;
	
	public Controller(Evaluator evaluator) { this.evaluator = evaluator; }

	@PostMapping(value="/eval", consumes = {"application/json"})
	public ResponseEntity<Object> evaluate(@RequestBody ExpressionModel body) {
		double ans = -999;
		try { ans = evaluator.compute(body.expression); }
		catch (Exception e) {
			return ResponseHandler.handle(0, HttpStatus.BAD_REQUEST);
		}
		return ResponseHandler.handle(ans, HttpStatus.OK);
	}
}
