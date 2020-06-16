package at.spg.controller;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import at.spg.model.Greetings;
import at.spg.repositorys.GreetingRepository;

@RestController // This means that this class is a Controller
@RequestMapping(path="/greeting") // This means URL's start with /demo (after Application path)

public class Controller {


	@Autowired 
	private GreetingRepository greetingRepository;

	@GetMapping
	public @ResponseBody Iterable<Greetings> getAllGreeting() {
	  // This returns a JSON or XML with the users
	  return greetingRepository.findAll();
	}

	
	}

