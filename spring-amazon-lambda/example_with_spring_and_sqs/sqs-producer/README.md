## Required settings in lambda
It's necessary update the application-dev.properties with your access and secret key.
Add SQS URL too.

## How run the application by CLI
´´´
./gradlew bootRun --args='--spring.profiles.active=dev'
´´´
