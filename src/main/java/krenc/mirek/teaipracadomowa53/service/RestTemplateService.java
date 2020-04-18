package krenc.mirek.teaipracadomowa53.service;

import krenc.mirek.teaipracadomowa53.model.CurrencyMain;
import krenc.mirek.teaipracadomowa53.model.Rates;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    private final String URL ="https://api.exchangeratesapi.io/latest?base=PLN";
    private RestTemplate restTemplate;

    public RestTemplateService() {
        this.restTemplate = new RestTemplate();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getCurrencyList()
    {
        CurrencyMain currencyMain = restTemplate.getForObject(URL, CurrencyMain.class);
        Rates rates = currencyMain.getRates();
        System.out.println(rates);
        String symbol= rates.getRandomCurrencySymbol();
        System.out.println(symbol + "=" + rates.getCurrencyRate(symbol));
    }

}
