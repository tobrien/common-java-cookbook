project {
    modelVersion '4.0.0'
    parent {
        artifactId 'cjcook-parent'
        groupId 'com.discursive.cjcook'
        version '0.27-SNAPSHOT'
        relativePath '..'
    }
    artifactId 'cjcook-html'
    name 'Common Java Cookbook Chunked HTML Output'
    description 'A Common Cookbook for Java'
    dependencies {
        dependency {
            groupId '${project.groupId}'
            artifactId 'cjcook-content'
            version '${project.version}'
        }
    }
    build {
        resources {
            resource {
                filtering 'true'
                directory 'src/main/resources'
                includes {
                    include 'html_chunk.xsl'
                }
            }
        }
        plugins {
            plugin {
                groupId 'org.codehaus.cjcook'
                artifactId 'docbook-plugin'
                version '1.0'
            }
            plugin {
                artifactId 'maven-resources-plugin'
                version '2.3'
                configuration {
                    escapeString '\\'
                    encoding 'UTF-8'
                }
            }
            plugin {
                groupId 'com.agilejava.docbkx'
                artifactId 'docbkx-maven-plugin'
                version '2.0.9'
                executions {
                    execution {
                        id 'generate-html'
                        phase 'compile'
                        goals {
                            goal 'generate-html'
                        }
                    }
                }
                dependencies {
                    dependency {
                        groupId 'docbook'
                        artifactId 'docbook-xml'
                        version '4.5'
                    }
                }
                configuration {
                    htmlCustomization '${basedir}/target/classes/html_chunk.xsl'
                    sourceDirectory '${basedir}/target/docbook'
                    targetDirectory '${basedir}/target/html'
                    includes 'book-cjcook.xml'
                    xincludeSupported 'true'
                    chunkedOutput 'true'
                    chunkSectionDepth '1'
                    postProcess {
                        copy(todir:'${project.build.directory}/html/images') {
                            fileset(dir:'${basedir}/src/main/resources/images')
                        }
                        copy(todir:'${project.build.directory}/html/figs/web') {
                            fileset(dir:'target/docbook/figs/web')
                        }
                    }
                }
            }
            plugin {
                artifactId 'maven-dependency-plugin'
                executions {
                    execution {
                        id 'unpack'
                        phase 'generate-sources'
                        goals {
                            goal 'unpack'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-content'
                                    version '${project.version}'
                                }
                            }
                            outputDirectory '${basedir}/target/docbook'
                        }
                    }
                }
            }
            plugin {
                artifactId 'maven-jar-plugin'
                configuration {
                    classesDirectory '${basedir}/target/html'
                }
            }
        }
    }
}
