image:=registry.qingteng.cn/ms-infra/dataease/dataease:v1.18.10

build:
	@cd frontend && npm run build:stage && cd ..
	@cd backend && export JAVA_HOME=/usr/local/include/openjdk-11 && mvn clean package && cd ..
	@docker build -t ${image} .

clean: 
	@docker rm -f dataease
	@docker image rm ${image}

push:
	@docker push ${image}