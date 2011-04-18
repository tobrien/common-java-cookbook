project {
    modelVersion '4.0.0'
    parent {
        artifactId 'cjcook-parent'
        groupId 'com.discursive.cjcook'
        version '0.27-SNAPSHOT'
        relativePath '..'
    }
    artifactId 'cjcook-epub'
    name 'Common Java Cookbook (ePub)'
    description 'A book about a bunch of Java Components'
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
                    include 'epub-custom.xsl'
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
                version '${docbkx-tools.version}'
                executions {
                    execution {
                        id 'generate-epub'
                        phase 'compile'
                        goals {
                            goal 'generate-epub'
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
                    sourceDirectory '${basedir}/target/docbook'
                    targetDirectory '${basedir}/target/epub'
                    includes 'book-cjcook.xml'
                    xincludeSupported 'true'
                    bookFile '${project.build.directory}/book-cjcook.epub'
                    htmlStylesheet 'epub-custom.css'
                    epubCustomization '${basedir}/src/main/resources/epub-custom.xsl'
                    postProcess {
                        copy(todir:'${project.build.directory}/epub/figs/web') {
                            fileset(dir:'target/docbook/figs/web')
                        }
                        copy(todir:'${project.build.directory}/epub/covers') {
                            fileset(dir:'target/docbook/covers')
                        }
                        copy(file:'src/main/resources/epub-custom.css', todir:'${project.build.directory}/epub')
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
                    classesDirectory '${basedir}/target/epub'
                }
            }
            plugin {
                artifactId 'maven-install-plugin'
                executions {
                    execution {
                        id 'install-epub'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/epub/book-cjcook.epub'
                            groupId '${groupId}'
                            artifactId '${artifactId}'
                            version '${version}'
                            packaging 'epub'
                        }
                    }
                }
            }
        }
    }
}
