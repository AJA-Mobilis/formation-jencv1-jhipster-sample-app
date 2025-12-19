pipeline {
    agent any
    options {
        skipDefaultCheckout true
    }
    stages {
        stage('Checkout Git') {
            steps {
                checkout scmGit(
					branches: [[name: '*/main']], 
					extensions: [cleanBeforeCheckout(deleteUntrackedNestedRepositories: true)], 
					userRemoteConfigs: [[url: 'https://github.com/AJA-Mobilis/formation-jencv1-jhipster-sample-app']]
				)
            }
        }

        stage('Build') {
			steps {
				sh '''
					chmod u+x ./mwnw
					./mvnw clean install -DskipTests -Darguments="-Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Dmaven.javadoc.failOnError=false"
				'''
				archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
			}
        }
    }

    post {
        // Après exécution du pipeline quel que soit le résultat des étapes précédentes
        always {
            // Nettoyage du workspace
            cleanWs(deleteDirs: true, notFailBuild: true)
            echo 'End'
        }
    }
}