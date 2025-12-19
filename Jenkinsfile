pipeline {
    agent any
    stages {
        stage('Parallel stages') {
			parallel {
				stage('⚙️ Build') {
					steps {
						sh '''
							chmod u+x ./mvnw
							./mvnw clean install -DskipTests -Darguments="-Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Dmaven.javadoc.failOnError=false"
						'''
					}
				}
				stage('🧪 Tests') {
					steps {
						sh '''
							chmod u+x ./mvnw
							./mvnw surefire:test spotbugs:spotbugs
						'''
					}
				}
			}
        }
    }

    post {
        // Après exécution du pipeline quel que soit le résultat des étapes précédentes
        always {
			recordIssues sourceCodeRetention: 'LAST_BUILD', tools: [
				junitParser(pattern: '**/target/surefire-reports/*.xml', skipSymbolicLinks: true), 
				spotBugs(skipSymbolicLinks: true, useRankAsPriority: true)
			]
            // Nettoyage du workspace
            cleanWs(deleteDirs: true, notFailBuild: true)
            echo 'End'
        }
    }
}