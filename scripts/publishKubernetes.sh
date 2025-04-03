#!/usr/bin/env bash

echo "Publicando mysql no kubernetes..."
awk 'FNR==1 {print "---"}{print}' k8s/mysql/*.yaml | envsubst > kub-app.yaml
cat kub-app.yaml
kubectl apply -f kub-app.yaml -n java-api-token

echo "Publicando adminer no kubernetes..."
awk 'FNR==1 {print "---"}{print}' k8s/adminer/*.yaml | envsubst > kub-app.yaml
cat kub-app.yaml
kubectl apply -f kub-app.yaml -n java-api-token

echo "Publicando consumer no kubernetes..."
awk 'FNR==1 {print "---"}{print}' k8s/api/*.yaml | envsubst > kub-app.yaml
cat kub-app.yaml
kubectl apply -f kub-app.yaml -n java-api-token
