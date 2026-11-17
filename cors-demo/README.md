# CORS Demo (Spring Boot + HTML frontend)

Two Spring Boot projects:
- backend-api  -> http://localhost:8080  (REST API, /profile)
- frontend-app -> http://localhost:3000  (HTML page, different origin)

## Run in STS
1. File > Import > Maven > Existing Maven Projects > select the cors-demo folder > Finish (both projects appear).
2. Right-click BackendApplication.java > Run As > Spring Boot App.
3. Right-click FrontendApplication.java > Run As > Spring Boot App.
4. Open http://localhost:3000 in Chrome, press F12.

## Test
- Step 2: app.cors.enabled=false -> click buttons -> CORS error.
- Step 3: set app.cors.enabled=true in backend-api/src/main/resources/application.properties, restart backend.
- Step 4: refresh page -> GET and PUT work; DELETE is still blocked.
