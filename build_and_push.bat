call mvn clean install
docker build . -t marmiss/payment-service:1.0.0
docker push marmiss/payment-service:1.0.0