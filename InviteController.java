package pl.wind.humpback.app.scopesample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/debug/dialog/")
public class InviteController {

    @Autowired
    ApplicationContext ctx;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseEntity add(
            @RequestParam(value = "pesel") String pesel,
            @RequestParam(value = "city") String city) {

        Person person = ctx.getBean(Person.class);
        person.getAddress().setCity(city);

        return new ResponseEntity<String>("added " + person.descibe(), HttpStatus.OK);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ResponseEntity view(
            @RequestParam(value = "pesel") String pesel
    ) {

        Person person = ctx.getBean(Person.class);

        return new ResponseEntity<String>("view " + person.descibe(), HttpStatus.OK);
    }

}
