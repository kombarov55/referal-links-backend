package ru.mail.nakombarov.referallinksbackend.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.nakombarov.referallinksbackend.config.Dictionary;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryEndpoint {

    private final Dictionary dictionary;


    @GetMapping
    @RequestMapping("/countries")
    public List<String> countries() {
        return dictionary.getCountries();
    }

}
