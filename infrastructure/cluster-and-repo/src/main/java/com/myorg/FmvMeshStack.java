package com.myorg;

import software.amazon.awscdk.services.ec2.IVpc;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.VpcLookupOptions;
import software.amazon.awscdk.services.ecr.CfnRepository;
import software.amazon.awscdk.services.ecs.Cluster;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class FmvMeshStack extends Stack {
    public FmvMeshStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public FmvMeshStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        final String helloRepoName = "fmv-mesh/hello";

        CfnRepository repo = CfnRepository.Builder.create(this, helloRepoName)
                .repositoryName(helloRepoName)
                .build();



    }
}
