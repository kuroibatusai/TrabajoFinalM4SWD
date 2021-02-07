pipeline {
    agent any

    stages {
        stage('Contruir Backend') {
            steps {
                sh "./mvnw clean compile -e"
            }
        }
        stage('Iniciar Backend') {
            steps {
                sh "nohup bash mvnw spring-boot:run &"
                sleep 20
            }
        }
        stage('Probar Backend URL'){
            steps {
                sh "curl -X GET 'http://localhost:8082/rest/msdxc/dxc?sueldo=4900000&ahorro=45000000&fechaUf=06-02-2021'"
            }
        }
        stage('Instalar Frontend'){
            steps {
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
                    git clone https://github.com/michellobo/selenium_laboratorio
                    ls -lha
                    cd selenium_laboratorio
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