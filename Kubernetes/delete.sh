#!/bin/bash
kubectl delete -f mysql_volume.yaml 
kubectl delete -f postgres_volume.yaml 
kubectl delete -f central_deployment.yaml 
kubectl delete -f central_service.yaml 
kubectl delete -f city_deployment.yaml 
kubectl delete -f city_service.yaml 
kubectl delete -f ingress.yaml 
