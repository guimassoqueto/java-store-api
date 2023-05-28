GUI=xdg-open
PORT=8080

open-repo:
	open https://github.com/guimassoqueto/java-store-api

dir:
	${GUI} $$(pwd)

app-browser:
	open http://localhost:${PORT}/h2-console