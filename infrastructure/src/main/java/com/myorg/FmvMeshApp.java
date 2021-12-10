package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class FmvMeshApp {
    public static void main(final String[] args) {
        App app = new App();

        new FmvMeshStack(app, "FmvMeshStack", StackProps.builder()
                .build());

        app.synth();
    }
}

