package sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

	@GetMapping("/")
	public String index() {
		System.out.println("Got here!!");

		return "Got here";
	}
}