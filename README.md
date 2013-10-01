Using Merge Properties Maven Plugin
=============================

In the pom.xml file, add a new plugin. See the example

```
<build>
	<plugins>
		<plugin>
			<groupId>cl.pcollaog.plugins</groupId>
			<artifactId>merge-properties-maven-plugin</artifactId>
			<version>0.0.1-SNAPSHOT</version>
			<configuration>
				<merges>
					<config>
						<outputFilename>out.properties</outputFilename>
						<sourceDirectory>src/main/webapp/WEB-INF/messages</sourceDirectory>
						<outputDirectory>src/main/resources/messages/</outputDirectory>
						<pattern>*_es.properties</pattern>
					</config>
				</merges>
			</configuration>
		</plugin>
	</plugins>
</build>
```