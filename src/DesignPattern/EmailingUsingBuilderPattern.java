package src.DesignPattern;

public class EmailingUsingBuilderPattern {
    public static void main(String[] atrgs) {
        Email email = new EmailBuilders().senderAdd("abx@xby").receiverAdd("xyz@abx").subject("hi abc").body("ajdfjaf")
                .build();

        System.out.println(email.toString());

        Email email2 = new EmailBuilders().senderAdd("abx@xby").receiverAdd("xyz@abx").subject("hi abc").body("ajdfjaf")
                .attachement("attachemnt")
                .build();

        System.out.println(email2.toString());
    }
}

class Email {
    private String senderAdd;
    private String receiverAdd;
    private String ccAdd;
    private String bccAdd;
    private String subject;
    private String body;
    private String attachment;

    Email(EmailBuilders ebuilder) {
        this.senderAdd = ebuilder.senderAdd;
        this.receiverAdd = ebuilder.receiverAdd;
        this.ccAdd = ebuilder.ccAdd;
        this.bccAdd = ebuilder.bccAdd;
        this.subject = ebuilder.subject;
        this.body = ebuilder.body;
        this.attachment = ebuilder.attachment;
    }

    @Override
    public String toString() {
        return "Email{" +
                "senderAdd='" + senderAdd + '\'' +
                ", receiverAdd='" + receiverAdd + '\'' +
                ", ccAdd='" + ccAdd + '\'' +
                ", bccAdd='" + bccAdd + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}


class EmailBuilders {
    public String senderAdd;
    public String receiverAdd;
    public String ccAdd;
    public String bccAdd;
    public String subject;
    public String body;
    public String attachment;

    public EmailBuilders senderAdd(String senderAdd) {
        this.senderAdd = senderAdd;
        return this;
    }

    public EmailBuilders receiverAdd(String receiverAdd) {
        this.receiverAdd = receiverAdd;
        return this;
    }

    public EmailBuilders ccAdd(String ccAdd) {
        this.ccAdd = ccAdd;
        return this;
    }

    public EmailBuilders bccAdd(String bccAdd) {
        this.bccAdd = bccAdd;
        return this;
    }

    public EmailBuilders subject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilders body(String body) {
        this.body = body;
        return this;
    }

    public EmailBuilders attachement(String att) {
        this.attachment = att;
        return this;
    }

    public Email build() {
        return new Email(this);
    }
}