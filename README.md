This application uses a port 8080.

You can run the app and look at that in your browser at localhost:8080 
Then you should write the name of the currency you want to see the difference.

Example:
localhost:8080/RUB

Also, you can download a docker image from dicker repository using a command:
docker pull alekseysergeev89/currency_rate_gif
In order to run an images use a command:
sudo docker run -d -p 8080:8080 alekseysergeev89/currency_rate_gif