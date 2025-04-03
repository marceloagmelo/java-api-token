#!/usr/bin/env bash

echo "Removendo deployments e statefulsets no kubernetes..."
kubectl -n java-api-token delete deployment adminer api
kubectl -n java-api-token delete statefulset mysql

echo "Removendo services no kubernetes..."
kubectl -n java-api-token delete svc mysql-service adminer-service api-service

echo "Removendo ingress no kubernetes..."
kubectl -n java-craapipi-token delete ingress adminer-ingress api-ingress