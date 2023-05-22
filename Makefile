BROWSER=firefox --url
GUI=xdg-open
PORT=8080

open-repo:
	${BROWSER} https://github.com/guimassoqueto/java-store-api

open-folder:
	${GUI} $$(pwd)

app-browser:
	${BROWSER} http://localhost:${PORT}