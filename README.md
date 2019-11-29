# kafka-web-ui
The only web UI for kafka messages which uses the SASL usersname/passwords directly as logins.
This allows your team to view messages using SASL accounts and Admins to assign appropriate ACLs to them.

You can run this as a docker container `docker run rahulbats/kafka-web-ui:1.0.0 -e ALLOWED_USERS=[SASL USERS] SECURITY_PROTOCOL=[SECURITY PROTOCOL] BOOTSTRAP_SERVERS=[BOOTSTRAP SERVERS] SCHEMA_REGISTRY_URL=[OPTIONAL SCHEMA REGISTRY URL]` 

Then expose it as a service and access it as in browser as `http://[Service URL]/api/ui/index.html`

To run locally cd into the server folder build jar using `./gradlew clean build`

Then run the jar using `java -jar build/libs/kafka-web-ui-1.0.0.jar`

Open a browser and go to `http://localhost:8080/api/ui/index.html`
