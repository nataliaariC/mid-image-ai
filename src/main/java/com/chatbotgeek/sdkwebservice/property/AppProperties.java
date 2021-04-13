package com.chatbotgeek.sdkwebservice.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${url.kata.login}")
    String urlKataLogin;
     @Value("${kata.username}")
    String kataUsername;
    @Value("${kata.password}")
    String kataPassword;
    @Value("${url.kata.image}")
    String urlKataImage;

    public String getKataUsername() {
        return kataUsername;
    }

    public void setKataUsername(String kataUsername) {
        this.kataUsername = kataUsername;
    }

    public String getKataPassword() {
        return kataPassword;
    }

    public void setKataPassword(String kataPassword) {
        this.kataPassword = kataPassword;
    }

    public String getUrlKataImage() {
        return urlKataImage;
    }

    public void setUrlKataImage(String urlKataImage) {
        this.urlKataImage = urlKataImage;
    }
    
    public String getUrlKataLogin() {
        return urlKataLogin;
    }

    public void setUrlKataLogin(String urlKataLogin) {
        this.urlKataLogin = urlKataLogin;
    }    
}
