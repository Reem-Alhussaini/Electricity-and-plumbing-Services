package builder;

public class InvoiceEngineer {
    private Builder builder;

    public InvoiceEngineer(Builder builder) {
        this.builder = builder;
    }

    public Invoice getBuilder() {
        return builder.build();
    }

    public void makeInvoice(){
        this.builder.buildName();

    }
}
