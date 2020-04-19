package krenc.mirek.teaipracadomowa53.controller;

import krenc.mirek.teaipracadomowa53.model.CurrencyGameData;
import krenc.mirek.teaipracadomowa53.service.RestTemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class CurrencyController {

    private RestTemplateService restTemplateService;
    private CurrencyGameData randomCurrencyData;

    public CurrencyController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
        this.randomCurrencyData = restTemplateService.getRandomCurrencyMap();
    }

    @GetMapping
    public String getCurrencyData(Model model, HttpSession session)
    {
        model.addAttribute("currency", randomCurrencyData);
        model.addAttribute("guessCurrency", new CurrencyGameData());
        session.getAttribute("message");

        return "index";
    }

    @PostMapping
    public String guessRatio(CurrencyGameData guessingData, Model model, HttpSession session)
    {
        System.out.println("jest=" + randomCurrencyData.getCurrencyValue() + ", form=" + guessingData.getCurrencyValue());
        if (Double.compare(randomCurrencyData.getCurrencyValue(), guessingData.getCurrencyValue())==0)
        {
            session.setAttribute("message", "You won, indeed the value of 1 " + randomCurrencyData.getCurrencySymbol() + " is " +randomCurrencyData.getCurrencyValue()  + " PLN for today");
        }
        else if (Double.compare(randomCurrencyData.getCurrencyValue(), guessingData.getCurrencyValue())>0)
        {
            session.setAttribute("message", "Try again - you have not provided enough ...");
        }
        else if (Double.compare(randomCurrencyData.getCurrencyValue(), guessingData.getCurrencyValue())<0)
        {
            session.setAttribute("message", "Try again - you have entered too much ...");
        }

        return "redirect:/";
    }
}
