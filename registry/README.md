# A local Docker registry

## Assumption

A working Kubernetes (K8S) cluster

### Create a local Docker registry

```bash
docker run -d --restart=always -p 5000:5000 --name local-registry registry:2
docker network connect "kind" "local-registry"
```

### Sources

* [Local Kubernetes Development with kind](https://sookocheff.com/post/kubernetes/local-kubernetes-development-with-kind/), accessed 31 January 2021
