#!/bin/bash
kubectl apply -f mysql_volume.yaml
kubectl apply -f postgres_volume.yaml
kubectl apply -f central_deployment.yaml
kubectl apply -f central_service.yaml
kubectl apply -f city_deployment.yaml
kubectl apply -f city_service.yaml
# kubectl apply -f ingress.yaml