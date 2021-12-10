mvn compile jib:dockerBuild 


aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin $PA_ACCOUNT_NO.dkr.ecr.$AWS_REGION.amazonaws.com

docker push $PA_ACCOUNT_NO.dkr.ecr.$AWS_REGION.amazonaws.com/fmv-mesh/hello:1.0-SNAPSHOT


