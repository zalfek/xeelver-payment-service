call mvn clean install
docker build . -t marmiss/payment-service:1.0.2
docker push marmiss/payment-service:1.0.2