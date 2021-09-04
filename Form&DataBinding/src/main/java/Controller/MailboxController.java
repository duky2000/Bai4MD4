package Controller;

import Model.Mailbox;
import Service.MailboxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailboxController {
    MailboxService mailboxService = new MailboxService();
    @RequestMapping("mailbox")
    public ModelAndView home() {
        Mailbox mailbox = new Mailbox();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list",mailbox);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Mailbox mailbox){
        mailboxService.add(mailbox);
        return new ModelAndView("redirect:/mailbox");
    }
}
