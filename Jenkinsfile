pipeline {
    agent any

    stages {
        stage('Build') {
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
                sleep 20
                sh "curl -X GET 'http://localhost:8082/rest/msdxc/dxc?sueldo=4900000&ahorro=45000000&fechaUf=06-02-2021'"
            }
        }    
        stage('Iniciar Frontend'){
            steps {
                sleep 20
                sh "cd webapp/devops-calculadora-10-webapp"
                sh "npm install && npm start"
            }
        }
        //end run
        /*
        stage('test') {
            steps {
                sh "./mvnw.cmd clean test -e"
            }
        }
        stage('Test Jmeter') {
            steps {
                sh '''
                    ./mvnw verify -Pperformance
                '''
            }
        }
        */
    }
}