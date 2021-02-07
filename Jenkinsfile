pipeline {
    agent any

    stages {
        stage('Contruir Backend') {
            steps {
                echo "Contruir Backend"
                sh "./mvnw clean compile -e"
            }
        }
        stage('Iniciar Backend') {
            steps {
                echo "Iniciar Backend"
                sh "nohup bash mvnw spring-boot:run &"
                sleep 20
            }
        }
        /*        
        stage('Probar Backend URL'){
            steps {
                echo "Probar Backend URL"
                sh "curl -X GET 'http://localhost:8082/rest/msdxc/dxc?sueldo=4900000&ahorro=45000000&fechaUf=06-02-2021'"
            }
        }
        stage('Probar Backend JUnit'){
            steps {
                echo "Probar Backend JUnit"
                sh "./mvnw test"
            }
        }
        */
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
                    npm start
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
                    ./mvnw clean compile
                    ./mvnw test
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
                    newman run postman/DEVOPS-Calc10.postman_collection.json
                '''
            }
        }
    }
}