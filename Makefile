.PHONY: start stop

all: start

start:
	./gradlew build
	docker compose up -d

stop:
	docker compose down
	./gradlew clean
	docker volume prune -f
	docker system prune -a