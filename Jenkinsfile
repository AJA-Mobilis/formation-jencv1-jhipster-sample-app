pipeline {
    agent any
    stages {
        stage('⚙️ Build + 🧪 Tests') {
			steps {
				sh 'chmod u+x ./mvnw'
				parallel(
					build: {
						sh './mvnw clean install -DskipTests -Darguments="-Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Dmaven.javadoc.failOnError=false"'
					},
					tests: {
						sh './mvnw surefire:test spotbugs:spotbugs'
					}
				)
				archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
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