package com.piddamsetty.rpigaragecontrol;

import com.piddamsetty.rpigaragecontrol.services.FileServices;
import com.piddamsetty.rpigaragecontrol.services.RpiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by praneet on 8/11/18.
 */
@RestController
public class WebPoint {
    FileServices fileServices;
    RpiService rpiService;
    String indexPage;

    @RequestMapping("/")
    public String root() {
        if(indexPage == null) {
            initialize();
        }
        return  indexPage;
    }


    @RequestMapping("/operatedoor")
    public void operateDoor(HttpServletResponse response) throws IOException {
        rpiService.openOrCloseDoor();
        response.sendRedirect("/");
    }





    private void initialize() {
        try {
            this.fileServices = new FileServices();
            this.rpiService = new RpiService();
            indexPage = fileServices.resourceFileRead("index.html");
        } catch (Exception e) {
            System.out.println("Unable to initialize WebPoint. Exception: "+e.getMessage());
        }
    }

}
