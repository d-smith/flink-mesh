package org.ds.appmesh;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

public class ServiceApp {
    public static void main(final String[] args) {
        App app = new App();
        Environment env = Environment.builder()
                .account(System.getenv("PA_ACCOUNT_NO"))
                .region(System.getenv("AWS_REGION"))
                .build();

        new ServiceStack(app, "ServiceStack", StackProps.builder()
                .env(env)
                .build());

        app.synth();
    }
}

