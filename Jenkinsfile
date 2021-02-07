pipeline {
    agent any

    stages {
        stage('Contruir Backend') {
            echo "Contruir Backend"
            steps {
                sh "./mvnw clean compile -e"
            }
        }
        stage('Iniciar Backend') {
            echo "Iniciar Backend"

            steps {
                sh "nohup bash mvnw spring-boot:run &"
                sleep 20
            }
        }
        stage('Probar Backend URL'){
            echo "Probar Backend URL"
            steps {
                sh "curl -X GET 'http://localhost:8082/rest/msdxc/dxc?sueldo=4900000&ahorro=45000000&fechaUf=06-02-2021'"
            }
        }
        stage('Probar Backend JUnit'){
            echo "Probar Backend JUnit"
            steps {
                sh "./mvnw test"
            }
        }
        stage('Instalar Frontend'){
            steps {
                echo "Instalar Frontend"
                sh '''
                    ls -lha
                    cd webapp/devops-calculadora-10-webapp
                    ls -lha
                    npm install
                '''
            }
        }
        stage('Iniciar Frontend'){
            steps {
                echo "Iniciar Frontend"
                sh '''
                    ls -lha
                    cd webapp/devops-calculadora-10-webapp
                    ls -lha
                    nohup npm start &
                    sleep 20
                '''
            }
        }
        stage('Iniciar Test Selenium') {
            steps {
                echo "Iniciar Test de Selenium"
                sh '''
                    ls -lha
                    rm -rf selenium_laboratorio
                    git clone https://github.com/michellobo/selenium_laboratorio
                    ls -lha
                    cd selenium_laboratorio
                    ls -lha
                    mvn clean compile
                    mvn test
                '''
            }
        }
        stage('Instalar NewMan') {
            steps {
                echo "Instalar NewMan"
                sh '''
                    ls -lha
                    npm install -g newman
                '''
            }
        }
        stage('Ejecutar NewMan') {
            steps {
                echo "Ejecutar NewMan"
                sh '''
                    ls -lha
                    newman postman/DEVOPS - Calc 10.postman_collection.json                    
                '''
            }
        }
    }
}