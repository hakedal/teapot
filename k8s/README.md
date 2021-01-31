# Multi-node Kubernetes (K8S) cluster

## Assumption

A working WSL 2 Docker installation.

### Install 'kubectl'

```sh
curl -Lo ./kubectl https://dl.k8s.io/release/v1.20.0/bin/linux/amd64/kubectl
chmod +x ./kubectl
sudo mv ./kubectl /usr/local/bin/.
```

### Install 'kind'

```sh
curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.9.0/kind-linux-amd64
chmod +x ./kind
sudo mv ./kind /usr/local/bin/.
```

### Create a cluster

```sh
kind create cluster --name k8s --config ./k8s-triple.yaml
```

### Add an ingress to K8S

```sh
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/static/provider/kind/deploy.yaml
```

### Add a dashboard to K8S

```sh
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.1.0/aio/deploy/recommended.yaml
kubectl apply -f service-account.yaml
kubectl apply -f authorization.yaml
```

### Get the token for the service account

```sh
kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')
```

### Start a kubectl proxy

```sh
kubectl proxy
```

### Then

Open: [http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/](http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/)

### Sources

* [Local Kubernetes Development with kind](https://sookocheff.com/post/kubernetes/local-kubernetes-development-with-kind/), accessed 31 January 2021
* [WSL+Docker: Kubernetes on the Windows Desktop](https://kubernetes.io/blog/2020/05/21/wsl-docker-kubernetes-on-the-windows-desktop/), accessed 31 January 2021
