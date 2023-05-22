BROWSER=firefox --url
GUI=xdg-open

open-repo:
	${BROWSER} https://github.com/guimassoqueto/java-store-api

open-folder:
	${GUI} $$(pwd)