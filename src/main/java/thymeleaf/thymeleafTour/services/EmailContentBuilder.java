package thymeleaf.thymeleafTour.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailContentBuilder {

    @Autowired
    private TemplateEngine templateEngine;

    public String build(String message) {
        Context context = new Context();
        context.setVariable("name", message);
        context.setVariable("title", "Thymeleaf");
        return templateEngine.process("home", context);
    }
}