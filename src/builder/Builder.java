package builder;


import java.util.Date;

// Builder interface
public interface Builder {
        void buildName();

        void buildServiceProviderName();

        void buildService();

        void buildDate();

        void buildPrice();

        Invoice build();
    }


