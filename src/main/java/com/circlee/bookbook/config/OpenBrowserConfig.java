package com.circlee.bookbook.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Profile("local")
@Configuration
public class OpenBrowserConfig {

    @Value("${server.port:8080}")
    int port;

    @EventListener({ApplicationReadyEvent.class})
    void applicationReadyEvent() {
        System.out.println("Application started ... launching browser now");
        openBrowser("http://localhost:" + port + "");
    }

    public static void openBrowser(String url) {
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }else{
            String os = System.getProperty("os.name");
            Runtime runtime = Runtime.getRuntime();
            try {
                if(os.toLowerCase().matches("mac os.*")) {
                    runtime.exec("open " + url);
                }

                if(os.toLowerCase().matches("windows .*")) {
                    runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
