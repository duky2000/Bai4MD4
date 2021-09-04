package Service;

import Model.Mailbox;

import java.util.ArrayList;

public class MailboxService {

    public ArrayList<Mailbox> list = new ArrayList<>();

    public MailboxService() {
        list.add(new Mailbox("English",15,false,"thor"));
    }

    public void add(Mailbox mailbox) {
        list.add(mailbox);
    }
}
