# A super simple Java-based HTTP-server

## Assumption

A working Kubernetes (K8S) cluster with a local Docker registry

### Build and push the Docker image

```sh
docker build -t localhost:5000/simple-sample:local .
docker push localhost:5000/simple-sample:local
```

### Deploy the HTTP-server

```sh
kubectl apply -f service.yaml
```

### Test the HTTP-server

```sh
$ curl -v localhost
* Trying 127.0.0.1:80...
...
> GET / HTTP/1.1
> Host: localhost
> User-Agent: curl/7.68.0
> Accept: */*
...
< HTTP/1.1 418
...
I'm a teapot 
```

### Sources

* [Local Kubernetes Development with kind](https://sookocheff.com/post/kubernetes/local-kubernetes-development-with-kind/), accessed 31 January 2021