package org.ds.appmesh;

import software.amazon.awscdk.services.ec2.IVpc;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.VpcLookupOptions;
import software.amazon.awscdk.services.ecr.IRepository;
import software.amazon.awscdk.services.ecr.Repository;
import software.amazon.awscdk.services.ecs.*;
import software.amazon.awscdk.services.iam.Role;
import software.amazon.awscdk.services.iam.ServicePrincipal;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class ServiceStack extends Stack {
    public ServiceStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public ServiceStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);
/*
        IVpc vpc = Vpc.fromLookup(this, "Vpc", VpcLookupOptions.builder()
                .isDefault(true)
                .build());

 */

        Vpc vpc = Vpc.Builder.create(this, "MyVpc")
                .maxAzs(3)  // Default is all AZs in region
                .build();

        Cluster cluster = Cluster.Builder.create(this, "fmv-cluster").vpc(vpc).build();



        Role taskRole = Role.Builder.create(this, "hello-task-role")
                .roleName("hello-task-role")
                .assumedBy(ServicePrincipal.Builder .create("ecs-tasks.amazonaws.com").build())
                .build();

        TaskDefinition taskDefinition = TaskDefinition.Builder.create(this, "hello-task-def")
                .taskRole(taskRole)
                .family("hello-task-def")
                .compatibility(Compatibility.EC2_AND_FARGATE)
                .networkMode(NetworkMode.AWS_VPC)
                .cpu("256")
                .memoryMiB("512")
                .build();


        IRepository repository = Repository.fromRepositoryName(this,"repo", "fmv-mesh/hello");

        EcrImage image = RepositoryImage.fromEcrRepository(repository, "1.0-SNAPSHOT");
        ContainerDefinition container = taskDefinition.addContainer("c1",
                ContainerDefinitionOptions.builder()
                        .image(image)
                        .logging(LogDriver.awsLogs(AwsLogDriverProps.builder().streamPrefix("hl").build()))
                        .memoryLimitMiB(512)
                        .build());

        FargateService service = FargateService.Builder.create(this, "hello-service")
                .cluster(cluster)
                .serviceName("hello-service")
                .desiredCount(1)
                .taskDefinition(taskDefinition)
                .build();


    }
}
