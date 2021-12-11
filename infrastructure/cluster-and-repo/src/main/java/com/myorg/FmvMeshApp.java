package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class FmvMeshApp {
    public static void main(final String[] args) {
        App app = new App();
        Environment env = Environment.builder()
                            .account(System.getenv("PA_ACCOUNT_NO"))
                            .region(System.getenv("AWS_REGION"))
                            .build();


        new FmvMeshStack(app, "FmvMeshStack", StackProps.builder().env(env)
                .build());

        app.synth();
    }
}

