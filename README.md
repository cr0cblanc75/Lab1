JDK 25

./gradlew build
./gradlew bootRun

## Commands API

`/` ------------ redirect --------> `/cars` <br>

| Commands                     | Usage                                     |
| ---------------------------- | ----------------------------------------- |
| `/cars`                      | display all the cars                      |
| `/cars?available`       | display all non-rented cars               |
| `/cars/{plateNumber}`        | display the desired cars                  |
| `/cars/{plateNumber}?toRent` | rent the desired car and display his data |
