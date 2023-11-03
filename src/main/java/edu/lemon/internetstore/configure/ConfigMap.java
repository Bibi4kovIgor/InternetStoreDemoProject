package edu.lemon.internetstore.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigMap {
    @Value("${paypal.password}")
    private String paypalPassword;

    private String paypalUrl;


    public ConfigMap(@Value("${paypal.url}") String paypalUrl) {
        this.paypalUrl = paypalUrl;
    }

    public String getPaypalPassword() {
        return paypalPassword;
    }

    public String getPaypalUrl() {
        return paypalUrl;
    }
}
