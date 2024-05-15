package builder;

// Director
public class InvoiceEngineer {
    private Builder builder;

    public InvoiceEngineer(Builder builder) {
        this.builder = builder;
    }

    public Invoice getInvoice() {
        return builder.build();
    }

    public void makeInvoice(){
        builder.buildName();
        builder.buildServiceProviderName();
        builder.buildService();
        builder.buildDate();
        builder.buildPrice();
    }
}
