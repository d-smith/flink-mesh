On local box...

```
docker network create my-net
docker run --name hello1 --network my-net -p 8080:8080 fmv-mesh/h1:0.0.1-SNAPSHOT
docker run --env ENDPOINT="http://hello1:8080" --network my-net fmv-mesh/hellosvc:0.0.1-SNAPSHOT
```
