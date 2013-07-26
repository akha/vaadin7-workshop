package ch.frankel.duchessswiss.vaadin.behavior;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;

public class ChatListener implements Button.ClickListener {

    private TextArea source;
    private TextArea target;

    public ChatListener(TextArea source, TextArea target) {

        this.source = source;
        this.target = target;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {

        String message = source.getValue();

        StringBuilder alreadyThere = new StringBuilder(target.getValue());

        if (alreadyThere.length() != 0) {

            alreadyThere.append("\n");
        }

        String login = VaadinSession.getCurrent().getAttribute(String.class);

        alreadyThere.append(login);
        alreadyThere.append(":");
        alreadyThere.append(" ");

        alreadyThere.append(message);

        target.setReadOnly(false);
        target.setValue(alreadyThere.toString());
        target.setReadOnly(true);
        source.setValue("");
    }
}