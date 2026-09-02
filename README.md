JDK 25

./gradlew build <br>
./gradlew bootRun

## Commands API

`/` ------------ redirect --------> `/cars` <br>

| Commands                     | Usage                                     |
| ---------------------------- | ----------------------------------------- |
| `/cars`                      | display all the cars                      |
| `/cars?available`       | display all non-rented cars               |
| `/cars/{plateNumber}`        | display the desired cars                  |
| `/cars/{plateNumber}?toRent` | rent the desired car and display his data |


## Commands h2-console
Après `./gradlew bootRun` go to 
> http://localhost:8080/h2-console

Then enter the JDBC URL of connection -> see the terminal
